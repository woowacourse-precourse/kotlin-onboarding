package onboarding

fun solution7mappingToInt(friends: List<List<String>>, visitors: List<String>, user:String): HashMap<String, Int> {
    val friendsId = HashMap<String, Int>()
    var id = 0

    friendsId[user]=id++
    friends.forEach { eachRelation ->
        val (friendA, friendB) = arrayOf(eachRelation[0], eachRelation[1])

        if (!friendsId.containsKey(friendA)) {
            friendsId[friendA] = id++
        }

        if (!friendsId.containsKey(friendB)) {
            friendsId[friendB] = id++
        }
    }

    visitors.forEach { friend ->
        if (!friendsId.containsKey(friend)) {
            friendsId[friend] = id++
        }
    }

    return friendsId
}

fun solution7makeFriendsRelation(friends: List<List<String>>, friendsId: HashMap<String, Int>): Array<ArrayList<Int>> {
    val friendsRelation = Array(friendsId.size) { ArrayList<Int>() }

    friends.forEach { eachRelation ->
        val (friendA, friendB) = arrayOf(eachRelation[0], eachRelation[1])

        friendsRelation[friendsId[friendA]!!].add(friendsId[friendB]!!)
        friendsRelation[friendsId[friendB]!!].add(friendsId[friendA]!!)
    }

    return friendsRelation
}

fun solution7dfs(
    cur: Int,
    depth: Int,
    friendsRelation: Array<ArrayList<Int>>,
    alreadyFriend: MutableSet<Int>,
    visited: BooleanArray,
    friendsScore: IntArray,
) {
    if (depth >= 2) return
    if (depth == 1) alreadyFriend.add(cur)
    friendsRelation[cur].forEach { next ->
        if (!visited[next]) {
            visited[next] = true
            if (depth + 1 == 2) {
                friendsScore[next] += 10
            }
            solution7dfs(next, depth + 1, friendsRelation, alreadyFriend, visited, friendsScore)
            visited[next] = false
        }
    }
}

fun solution7calcVisitorsScore(visitors: List<String>, friendsId: HashMap<String, Int>, friendsScore: IntArray) {
    visitors.forEach { friend ->
        friendsScore[friendsId[friend]!!]++
    }
}

fun IntArray.getResultRecommendation(friendsId: HashMap<String, Int>, alreadyFriend: MutableSet<Int>): List<String> {
    val friendsScore = ArrayList<Pair<String, Int>>()
    val friendsRecommendation = ArrayList<String>()
    friendsId.forEach { friend ->
        if (this[friend.value] > 0 && !alreadyFriend.contains(friend.value))
            friendsScore.add(Pair(friend.key, this[friend.value]))
    }

    friendsScore.toList().sortedWith(compareBy({ -it.second }, { it.first })).take(5).forEach {
        friendsRecommendation.add(it.first)
    }
    return friendsRecommendation.toList()
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {
    val friendsId = solution7mappingToInt(friends, visitors, user)
    val friendsRelation = solution7makeFriendsRelation(friends, friendsId)
    val friendsScore = IntArray(friendsId.size) { 0 }
    val visited = BooleanArray(friendsId.size) { false }
    val alreadyFriend = mutableSetOf<Int>()


    visited[friendsId[user]!!] = true
    solution7dfs(friendsId[user]!!, 0, friendsRelation, alreadyFriend, visited, friendsScore)
    solution7calcVisitorsScore(visitors, friendsId, friendsScore)

    return friendsScore.getResultRecommendation(friendsId, alreadyFriend)
}
