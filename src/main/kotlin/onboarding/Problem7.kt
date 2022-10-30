package onboarding

import kotlin.time.Duration.Companion.seconds

/*
기능 목록
- 사용자 친구 목록 구하기
- 친구 추천 점수 결정
- 추천 친구 목록 출력
*/
val usersFriends = mutableListOf<String>()
val friendsRecommendScore = mutableMapOf<String, Int>()

fun getFriendList(user: String, friends: List<List<String>>) {
    for (i in friends) {
        if (i.contains(user)) {
            val friendIdx = 1 - i.indexOf(user)
            usersFriends.add(i[friendIdx])
        }
    }
}

fun determineScore(user: String, friends: List<List<String>>, visitors: List<String>) {
    for (i in visitors) {
        if (usersFriends.contains(i))
            continue
        friendsRecommendScore[i] = (friendsRecommendScore[i] ?: 0) + 1
    }
    for (i in friends) {
        for (j in i.indices) {
            if (usersFriends.contains(i[j])) {
                val friend = i[1 - j]
                if (friend == user || usersFriends.contains(friend))
                    break
                friendsRecommendScore[friend] = (friendsRecommendScore[friend] ?: 0) + 10
            }
        }
    }
}

fun determineRecommendList(): List<String> {
    var tempScore = friendsRecommendScore.toList()
    val comparator = compareByDescending<Pair<String, Int>> { it.second } . thenBy { it.first }
    tempScore = tempScore.sortedWith(comparator)
    return tempScore.map { it.first }
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    getFriendList(user, friends)
    determineScore(user, friends, visitors)
    return determineRecommendList()
}
