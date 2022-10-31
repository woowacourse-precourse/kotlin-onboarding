package onboarding

/*
기능항목 정리
1. 이미 친구인 유저와 아닌 유저 구분하기 기능
2. 함께 아는 친구인 경우 +10 점 주기 기능
3. visitors 타임라인에 방문한 횟수당 1점 주기 기능
4. 점수별로 내림차순으로 정렬하고 최대 5명까지만 리턴하기 기능
 */
fun solution7(
    user: String, friends: List<List<String>>, visitors: List<String>
): List<String> {
    val allUserSet = mutableSetOf<String>()
    val friendSet = mutableSetOf<String>()
    val nonFriendMap = mutableMapOf<String, Int>()
    val result = arrayListOf<String>()

    friends.forEach { list ->
        val user1 = list[0]
        val user2 = list[1]
        when (user) {
            user1 -> {
                allUserSet.add(user2)
                friendSet.add(user2)
            }

            user2 -> {
                allUserSet.add(user1)
                friendSet.add(user1)
            }

            else -> {
                allUserSet.add(user1)
                allUserSet.add(user2)
            }
        }
    }

    visitors.forEach { userName ->
        if (userName != user) allUserSet.add(userName)
    }

    val nonFriendSet = allUserSet - friendSet
    nonFriendSet.forEach { userName ->
        nonFriendMap[userName] = 0
    }

    friends.forEach { list ->
        val user1 = list[0]
        val user2 = list[1]
        for (notFriend in nonFriendSet) {
            if (notFriend == user1 && friendSet.contains(user2)) nonFriendMap[notFriend] =
                nonFriendMap[notFriend]!! + 10
            if (notFriend == user2 && friendSet.contains(user1)) nonFriendMap[notFriend] =
                nonFriendMap[notFriend]!! + 10
        }
    }

    nonFriendSet.forEach { userName ->
        nonFriendMap[userName] = nonFriendMap[userName]!! + visitors.count { it == userName }
    }

    val recommendationFriendsMap = nonFriendMap.filter { it.value != 0 }
        .toList()
        .sortedBy { it.first }
        .sortedByDescending { it.second }
        .toMap()

    var count = 0
    for (map in recommendationFriendsMap) {
        if (count == 5) break
        result.add(map.key)
        count++
    }
    return result.toList()
}