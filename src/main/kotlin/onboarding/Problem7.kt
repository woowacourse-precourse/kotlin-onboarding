package onboarding

import java.util.LinkedList

fun solution7(
    user: String, friends: List<List<String>>, visitors: List<String>
): List<String> {
    val friendInformation = getFriendInformation(friends, visitors)

    return getScoreList(user, friendInformation, visitors)
}

fun getFriendInformation(friends: List<List<String>>, visitors: List<String>): Map<String, LinkedList<String>> {
    val friendInformation = LinkedHashMap<String, LinkedList<String>>()

    for (element in friends) {
        friendInformation[element[0]] = friendInformation[element[0]] ?: LinkedList<String>()
        friendInformation[element[1]] = friendInformation[element[1]] ?: LinkedList<String>()
        friendInformation[element[0]]?.add(element[1])
        friendInformation[element[1]]?.add(element[0])
    }
    for (visitor in visitors) {
        if (!friendInformation.containsKey(visitor)) {
            friendInformation[visitor] = LinkedList<String>()
        }
    }

    return friendInformation
}

fun getScoreList(
    user: String, friendInformation: Map<String, LinkedList<String>>, visitors: List<String>
): List<String> {
    val scoreMap = mutableMapOf<String, Int>()
    val userFriends = friendInformation[user] ?: LinkedList<String>()

    for (relationship in friendInformation) {
        val anotherUser = relationship.component1()
        val anotherUserFriends = relationship.component2()

        if (user == anotherUser || userFriends.contains(anotherUser)) {
            continue
        }
        var score = 0
        score += countAcquaintance(userFriends, anotherUserFriends) * 10
        print(anotherUser + countAcquaintance(userFriends, anotherUserFriends))
        score += countNumberOfVisits(anotherUser, visitors)
        print(anotherUser + countNumberOfVisits(anotherUser, visitors))

        if (score > 0) {
            scoreMap[anotherUser] = score
        }
    }

    return scoreMap.toList().sortedWith(compareBy({ -it.second }, { it.first })).map { it.first }
}

fun countAcquaintance(userFriends: LinkedList<String>, anotherUserFriends: LinkedList<String>): Int {
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