package onboarding

fun solution7(
    user: String, friends: List<List<String>>, visitors: List<String>
): List<String> {
    val friendInformation = getFriendInformation(friends, visitors)

    return getRecommendList(user, friendInformation, visitors)
}

private fun getFriendInformation(
    friends: List<List<String>>,
    visitors: List<String>
): Map<String, MutableList<String>> {
    val friendInformation = LinkedHashMap<String, MutableList<String>>()

    friends.forEach { relationship ->
        val user1 = relationship[0]
        val user2 = relationship[1]

        if (!friendInformation.containsKey(user1)) {
            friendInformation[user1] = mutableListOf()
        }
        friendInformation[user1]?.add(user2)

        if (!friendInformation.containsKey(user2)) {
            friendInformation[user2] = mutableListOf()
        }
        friendInformation[user2]?.add(user1)
    }

    visitors.forEach { visitor ->
        if (!friendInformation.containsKey(visitor)) {
            friendInformation[visitor] = mutableListOf()
        }
    }

    return friendInformation
}

private fun getRecommendList(
    user: String, friendInformation: Map<String, MutableList<String>>, visitors: List<String>
): List<String> {
    val scoreMap = mutableMapOf<String, Int>()
    val userFriends = friendInformation[user] ?: mutableListOf()

    for (relationship in friendInformation) {
        val anotherUser = relationship.component1()
        val anotherUserFriends = relationship.component2()

        if (user == anotherUser || userFriends.contains(anotherUser)) {
            continue
        }
        var score = 0
        score += countAcquaintance(userFriends, anotherUserFriends) * 10
        score += countNumberOfVisits(anotherUser, visitors)

        if (score > 0) {
            scoreMap[anotherUser] = score
        }
    }

    var recommendList = scoreMap.toList().sortedWith(compareBy({ -it.second }, { it.first })).map { it.first }
    if (recommendList.size > 5) {
        recommendList = recommendList.subList(0, 5)
    }

    return recommendList
}

private fun countAcquaintance(userFriends: MutableList<String>, anotherUserFriends: MutableList<String>): Int {
    var count = 0

    userFriends.forEach { userFriend ->
        anotherUserFriends.forEach { anotherUserFriend ->
            if (userFriend == anotherUserFriend) {
                count += 1
            }
        }
    }

    return count
}

private fun countNumberOfVisits(anotherUser: String, visitors: List<String>): Int {
    var count = 0

    visitors.forEach { visitor ->
        if (anotherUser == visitor) {
            count += 1
        }
    }

    return count
}