package onboarding
/* 기능 목록
* 친구 관계 저장
* 사용자의 친구들과 친구인 사람들의 점수 계산
* 방문자 점수 계산
* 정렬 및 출력
* */

const val WITH_FRIEND_SCORE = 10
const val VISITOR_SCORE = 1

fun getFriendshipMap(friends: List<List<String>>): MutableMap<String, MutableSet<String>> {
    val friendshipMap = mutableMapOf<String, MutableSet<String>>()
    friends.forEach {
        val (f1, f2) = it
        if (friendshipMap[f1] == null) {
            friendshipMap[f1] = mutableSetOf()
        }
        if (friendshipMap[f2] == null) {
            friendshipMap[f2] = mutableSetOf()
        }
        friendshipMap[f1]!!.add(f2)
        friendshipMap[f2]!!.add(f1)
    }
    return friendshipMap
}


fun calculateFriendScore(
    friendshipMap: MutableMap<String, MutableSet<String>>,
    scoreMap: MutableMap<String, Int>,
    user: String,
    withFriendScore: Int,
) {
    friendshipMap[user]?.forEach { friend ->
        friendshipMap[friend]?.forEach { withFriend ->
            if (withFriend != user) {
                scoreMap[withFriend] = scoreMap.getOrDefault(withFriend, 0) + withFriendScore
            }
        }
    }
}

fun calculateVisitorScore(
    friendshipMap: MutableMap<String, MutableSet<String>>,
    scoreMap: MutableMap<String, Int>,
    visitors: List<String>,
    user: String,
    visitorScore: Int,
) {
    visitors.forEach { visitor ->
        if (friendshipMap[user]?.contains(visitor) == false) {
            scoreMap[visitor] = scoreMap.getOrDefault(visitor, 0) + visitorScore
        }
    }
}

fun getScoreResultList(scoreMap: MutableMap<String, Int>): List<String> {
    return scoreMap
        .toList()
        .sortedWith(
            compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }
        ).map { it.first }
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {
    val friendshipMap = getFriendshipMap(friends)
    val scoreMap = mutableMapOf<String, Int>()
    calculateFriendScore(friendshipMap, scoreMap, user, WITH_FRIEND_SCORE)
    calculateVisitorScore(friendshipMap, scoreMap, visitors, user, VISITOR_SCORE)
    return getScoreResultList(scoreMap)
}




