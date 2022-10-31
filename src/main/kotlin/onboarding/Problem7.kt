package onboarding


fun mapToInt(friends: List<List<String>>, visitors: List<String>, user:String): HashMap<String, Int> {
    val friendsId = HashMap<String, Int>()
    var id = 0

    friendsId[user]=id++
    //각 friend의 String을 숫자에 mapping 시키기
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

//주어진 친구 관계에 대해서 graph를 형성한다
fun makeFriendsRelation(friends: List<List<String>>, friendsId: HashMap<String, Int>): Array<ArrayList<Int>> {
    val friendsRelation = Array(friendsId.size) { ArrayList<Int>() }

    friends.forEach { eachRelation ->
        val (friendA, friendB) = arrayOf(eachRelation[0], eachRelation[1])

        friendsRelation[friendsId[friendA]!!].add(friendsId[friendB]!!)
        friendsRelation[friendsId[friendB]!!].add(friendsId[friendA]!!)
    }

    return friendsRelation
}

fun calcConnectedScore(
    cur: Int,
    depth: Int,
    friendsRelation: Array<ArrayList<Int>>,
    alreadyFriend: MutableSet<Int>,
    visited: BooleanArray,
    friendsScore: IntArray,
) {
    if (depth >= 2) return

    //직접적으로 연결된 친구인 경우
    if (depth == 1) alreadyFriend.add(cur)
    friendsRelation[cur].forEach { next ->
        if (!visited[next]) {
            visited[next] = true

            //함꼐 아는 친구인 경우
            if (depth + 1 == 2) {
                friendsScore[next] += 10
            }
            calcConnectedScore(next, depth + 1, friendsRelation, alreadyFriend, visited, friendsScore)
            visited[next] = false
        }
    }
}

fun calcVisitorsScore(visitors: List<String>, friendsId: HashMap<String, Int>, friendsScore: IntArray) {
    visitors.forEach { friend ->
        friendsScore[friendsId[friend]!!]++
    }
}

fun IntArray.getResultRecommendation(friendsId: HashMap<String, Int>, alreadyFriend: MutableSet<Int>): List<String> {
    val friendsScore = ArrayList<Pair<String, Int>>()
    val friendsRecommendation = ArrayList<String>()

    //점수가 0점이 아니면서 직접적인 친구가 아닌 경우
    friendsId.forEach { friend ->
        if (this[friend.value] > 0 && !alreadyFriend.contains(friend.value))
            friendsScore.add(Pair(friend.key, this[friend.value]))
    }

    //점수를 기준으로 내림차순 정렬 (같은 경우 닉네임에 대해 오름차순)
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
    val friendsId = mapToInt(friends, visitors, user)
    val friendsRelation = makeFriendsRelation(friends, friendsId)
    val friendsScore = IntArray(friendsId.size) { 0 }
    val visited = BooleanArray(friendsId.size) { false }
    val alreadyFriend = mutableSetOf<Int>()

    alreadyFriend.add(friendsId[user]!!)
    visited[friendsId[user]!!] = true
    calcConnectedScore(friendsId[user]!!, 0, friendsRelation, alreadyFriend, visited, friendsScore)

    calcVisitorsScore(visitors, friendsId, friendsScore)

    return friendsScore.getResultRecommendation(friendsId, alreadyFriend)
}
