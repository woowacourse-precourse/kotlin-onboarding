package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val myFriends = hashSetOf<String>()
    val recommendMap = hashMapOf<String, Int>()

    // 1. 친구 목록 추가
    for ((user1, user2) in friends) {
        when (user) {
            user1 -> myFriends.add(user2)
            user2 -> myFriends.add(user1)
        }
    }

    // 2. 추천 맵에 간접 친구 점수 추가
    for ((user1, user2) in friends) {
        val indirect = when {
            (user1 in myFriends) && (user2 != user) && (user2 !in myFriends) -> user2
            (user2 in myFriends) && (user1 != user) && (user1 !in myFriends) -> user1
            else -> continue
        }

        recommendMap[indirect] = recommendMap.getOrDefault(indirect, 0) + 10
    }

    // 3. 추천 맵에 친구가 아닌 방문자 점수 추가
    for (visitor in visitors) {
        if (visitor in myFriends || visitor == user)
            continue

        recommendMap[visitor] = recommendMap.getOrDefault(visitor, 0) + 1
    }

    return recommendMap.asSequence()
        .sortedWith { e1, e2 ->
            val a = e2.value.compareTo(e1.value)
            val b = e1.key.compareTo(e2.key)

            if (a != 0) a else b
        }
        .map { it.key }
        .take(5)
        .toList()
}