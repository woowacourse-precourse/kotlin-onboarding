package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendsRelation = mutableMapOf<String, MutableSet<String>>()
    val points = mutableMapOf<String, Int>()
    val result = mutableListOf<String>()

    for (idx: Int in friends.indices) { // (이름, 친구명단) map 생성
        if (!friendsRelation.containsKey(friends[idx][0])) {
            friendsRelation[friends[idx][0]] = mutableSetOf()
        }
        if (!friendsRelation.containsKey(friends[idx][1])) {
            friendsRelation[friends[idx][1]] = mutableSetOf()
        }
        friendsRelation[friends[idx][0]]!!.add(friends[idx][1])
        friendsRelation[friends[idx][1]]!!.add(friends[idx][0])

    }
    // 함께 아는 친구의 수의 점수 계산
    if (friendsRelation.containsKey(user)) {
        val userFriends = friendsRelation[user]!!.toList()
        for (idx: Int in userFriends.indices) {
            val fFriends = friendsRelation[userFriends[idx]]!!.toList()
            for (idx2: Int in fFriends.indices) {
                if (fFriends[idx2] == user) {
                    continue
                }
                if (!points.containsKey(fFriends[idx2])) {
                    points[fFriends[idx2]] = 0
                }
                points[fFriends[idx2]] = points[fFriends[idx2]]!! + 10

            }
        }
    }
    // 방문 점수 계산
    for (idx: Int in visitors.indices) {
        if (friendsRelation.containsKey(user) && friendsRelation[user]!!.contains(visitors[idx])) { // 자기자신 제외
            continue
        }
        if(!points.containsKey(visitors[idx])) {
            points[visitors[idx]] = 0
        }
        points[visitors[idx]] = points[visitors[idx]]!! + 1

    }

    val candidates = points.toList().sortedByDescending { it.second }
    for (i: Int in candidates.indices) {
        result.add(candidates[i].first)
        if (result.size > 5) {
            break
        }
    }
    return result

}

//fun main() {
//    val friends = listOf(listOf("donut", "andole"),
//            listOf("donut", "jun"),
//            listOf("donut", "mrko"),
//            listOf("shakevan", "andole"),
//            listOf("shakevan", "jun"),
//            listOf("shakevan", "mrko"))
//    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
//    solution7("mrko", friends, visitors)
//}