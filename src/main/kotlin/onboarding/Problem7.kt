package onboarding

fun solution7(
    user: String, friends: List<List<String>>, visitors: List<String>
): List<String> {
    val friendInformation = getFriendInformation(friends, visitors)

    return getScoreList(user, friendInformation, visitors)
}

fun getFriendInformation(friends: List<List<String>>, visitors: List<String>): Map<String, MutableList<String>> {
    val friendInformation = LinkedHashMap<String, MutableList<String>>()

    for (relationship in friends) {
        val user1 = relationship[0]
        val user2 = relationship[1]

        if (!friendInformation.containsKey(user1)) {
            friendInformation[user1] = mutableListOf(user2)
        } else {
            friendInformation[user1]?.add(user2)
        }

        if (!friendInformation.containsKey(user2)) {
            friendInformation[user2] = mutableListOf(user1)
        } else {
            friendInformation[user2]?.add(user1)
        }

    }
    for (visitor in visitors) {
        if (!friendInformation.containsKey(visitor)) {
            friendInformation[visitor] = mutableListOf()
        }
    }

    return friendInformation
}

fun getScoreList(
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

    return scoreMap.toList().sortedWith(compareBy({ -it.second }, { it.first })).map { it.first }
}

fun countAcquaintance(userFriends: MutableList<String>, anotherUserFriends: MutableList<String>): Int {
    var count = 0

    for (userFriend in userFriends) {
        for (anotherUserFriend in anotherUserFriends) {
            if (userFriend == anotherUserFriend) {
                count += 1
            }
        }
    }

    return count
}

fun countNumberOfVisits(anotherUser: String, visitors: List<String>): Int {
    var count = 0

    for (visitor in visitors) {
        if (anotherUser == visitor) {
            count += 1
        }
    }

    return count
}