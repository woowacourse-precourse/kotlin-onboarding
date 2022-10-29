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
    //user는 추천 친구목록에서 제외
    friendScore.remove(user)

    //점수 기준 내림차순 (같은 경우 이름 기준 오름차순)
    friendScore.toList().sortedWith(compareBy({ -it.second }, { it.first })).forEach { eachFriend ->
        if (friendRelation[user]?.contains(eachFriend.first) == false) {
            resultRecommendation.add(eachFriend.first)
        }
    }

    return resultRecommendation.toList().take(5)
}

fun solution7calcConnectedFriendScore(
    curFriend: String,
    friendRelation: HashMap<String, MutableSet<String>>,
    usedPath: MutableSet<Pair<String, String>>,
    friendScore: HashMap<String, Int>,
) {
    friendRelation[curFriend]?.forEach { nextFriend ->
        if (!usedPath.contains(Pair(curFriend, nextFriend))) {
            //특정 간선을 기준으로 연결된 두 노드의 점수를 증가시킨다
            //B가 A를 알고있다(A의 score+10) <- A와 B가 친구이다 -> A가 B를 알고있다(B의 score+10)
            //user를 기준으로 탐색을 시작하기 때문에 user와 연관성이 전혀 없는 친구에 대한 점수는 증가하지 않음.
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
    visitors.forEach { eachVisitor ->
        friendScore[eachVisitor]?.let { score ->
            friendScore[eachVisitor] = score + 1
        } ?: run {
            friendScore[eachVisitor] = 1
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


