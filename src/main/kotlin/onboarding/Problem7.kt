package onboarding

import java.util.PriorityQueue

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    // 추천 받을 유저의 친구 목록
    val userFriends: Set<String> = getUserFriends(user, friends)

    // 친구들의 친구 목록 - 유저의 친구 목록 -> Set
    val friendOfFriends = mutableSetOf<String>()
    for (friend in userFriends) {
        val nearFriends = getUserFriends(friend, friends)
        friendOfFriends.addAll(nearFriends.minus(userFriends))
    }

    // 리스트 저장
    val friendToScore = HashMap<String, Int>()
    for (friend in friendOfFriends) {
        friendToScore[friend] = 10
    }

    // 방문자 목록 - 유저의 친구 목록
    val nonFriendVisitors = visitors.filterNot { it in userFriends }
    for (friend in nonFriendVisitors) {
        friendToScore.merge(friend, 1, Integer::sum)
    }

    // 정렬
    val recommends = PriorityQueue<Pair<String, Int>>(compareBy({ it.second * -1 }, { it.first }))
    for ((name, score) in friendToScore) {
        if (score != 0) {
            recommends.add(name to score)
        }
    }

    val answer = mutableListOf<String>()

    repeat(5) {
        val recommend = recommends.poll()?.first ?: return answer
        answer.add(recommend)
    }

    return answer
}

private fun getUserFriends(user: String, friends: List<List<String>>): Set<String> {
    val userFriends = mutableSetOf<String>()
    for (relation in friends) {
        if (user in relation) {
            userFriends.addAll(relation)
        }
    }
    return userFriends
}