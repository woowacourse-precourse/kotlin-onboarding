package onboarding

fun solution7makeFriendRelations(friends: List<List<String>>, friendRelation: HashMap<String, MutableSet<String>>) {
    friends.forEach { eachRelation ->
        val (friendA, friendB) = arrayOf(eachRelation[0], eachRelation[1])
        friendRelation[friendA]?.add(friendB) ?: run {
            friendRelation[friendA] = mutableSetOf(friendB)
        }
        friendRelation[friendB]?.add(friendA) ?: run {
            friendRelation[friendB] = mutableSetOf(friendA)
        }
    }
}

fun solution7filteringResult(
    user: String,
    friendScore: HashMap<String, Int>,
    friendRelation: HashMap<String, MutableSet<String>>,
): List<String> {
    val resultRecommendation = ArrayList<String>()
    friendScore.remove(user)
    friendScore.toList().sortedWith(compareBy({ -it.second }, { it.first })).forEach { eachFriend ->
        if (friendRelation[user]?.contains(eachFriend.first)==false) {
            resultRecommendation.add(eachFriend.first)
        }
    }

    return resultRecommendation.toList()
}

fun solution7calcConnectedFriendScore(
    curFriend: String,
    friendRelation: HashMap<String, MutableSet<String>>,
    usedPath: MutableSet<Pair<String, String>>,
    friendScore: HashMap<String, Int>,
) {
    friendRelation[curFriend]?.forEach { nextFriend ->
        if (!usedPath.contains(Pair(curFriend, nextFriend))) {
            solution7addScore(friendScore, curFriend)
            solution7addScore(friendScore, nextFriend)
            solution7recordPath(curFriend, nextFriend, usedPath)
            solution7calcConnectedFriendScore(nextFriend, friendRelation, usedPath, friendScore)
        }
    }
}

fun solution7addScore(friendScore: HashMap<String, Int>, friend: String) {
    friendScore[friend]?.let { score ->
        friendScore[friend] = score + 10
    } ?: run {
        friendScore[friend] = 10
    }
}

fun solution7recordPath(curFriend: String, nextFriend: String, usedPath: MutableSet<Pair<String, String>>) {
    usedPath.add(Pair(curFriend, nextFriend))
    usedPath.add(Pair(nextFriend, curFriend))
}

fun solution7addVisitorsScore(friendScore: HashMap<String, Int>, visitors: List<String>) {
    visitors.forEach { eachVisitor->
        friendScore[eachVisitor]?.let{score->
            friendScore[eachVisitor]=score+1
        }?:run{
            friendScore[eachVisitor]=1
        }
    }
}


fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {
    val friendRelation = HashMap<String, MutableSet<String>>()
    val usedPath = mutableSetOf<Pair<String, String>>()
    val friendScore = HashMap<String, Int>()

    solution7makeFriendRelations(friends, friendRelation)
    solution7calcConnectedFriendScore(
        curFriend = user,
        friendRelation,
        usedPath,
        friendScore
    )
    solution7addVisitorsScore(friendScore, visitors)
    return solution7filteringResult(user, friendScore, friendRelation)
}


