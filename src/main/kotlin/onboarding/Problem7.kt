package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val scoreMap = mutableMapOf<String, Int>()
    val friendsMap = createFriendsMap(friends, user)
    val userFriends = user.getFriendsOf(friendsMap)
    val scoreWeight = 10

    visitors.toSet()
        .forEach { visitor ->
            scoreMap[visitor] = getVisitCount(visitors, userFriends, visitor)
        }

    userFriends.forEach { friend ->
        friendsMap[friend]?.forEach { friendOfFriend ->
            if (friendOfFriend in userFriends) {
                return@forEach
            }
            val currentScore = scoreMap[friendOfFriend] ?: 0
            scoreMap[friendOfFriend] = currentScore + scoreWeight
        }
    }

    return scoreMap.filterNot { (_, score) ->
        score == 0
    }
        .toList()
        .sortedWith(compareByDescending<Pair<String, Int>> { (_, score) ->
            score
        }.thenBy { (name, _) ->
            name
        })
        .toMap()
        .keys
        .toList()
}

private fun createFriendsMap(friendRelations: List<List<String>>, user: String): Map<String, List<String>> {
    val friendsMap = mutableMapOf<String, MutableList<String>>()

    friendRelations.forEach { relation ->
        val friendA = relation[0]
        val friendB = relation[1]

        friendsMap[friendA] = addFriend(friendsMap[friendA], user, friendB)
        friendsMap[friendB] = addFriend(friendsMap[friendB], user, friendA)
    }

    return friendsMap
}

private fun addFriend(friends: MutableList<String>?, user: String, newFriend: String): MutableList<String> {
    return (friends ?: mutableListOf()).apply {
        if (user != newFriend) {
            add(newFriend)
        }
    }
}

private fun getVisitCount(visitors: List<String>, userFriends: List<String>, user: String): Int =
    visitors.filterNot { visitor ->
        visitor in userFriends
    }.count { visitor ->
        visitor == user
    }

private fun String.getFriendsCount(friendsMap: Map<String, List<String>>): Int =
    (friendsMap[this] ?: mutableListOf()).size

private fun String.getFriendsOf(friendsMap: Map<String, List<String>>): List<String> {
    return friendsMap[this] ?: mutableListOf()
}