package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val friendsRelation = initializeFriendsRelation(friends)
    var usersScore = mutableMapOf<String, Int>()
    if (friendsRelation[user].isNullOrEmpty()) return listOf("")

    usersScore = scoreMutualfriends(user, friendsRelation, usersScore)
    usersScore = scoreVisitedUser(visitors, usersScore)
    usersScore = deleteOneBridgeAndMe(user, usersScore, friendsRelation)

    return usersScore.asSequence()
        .sortedWith { a1, a2 ->
            val sortedMaxScoreIdx = a2.value.compareTo(a1.value)

            if (sortedMaxScoreIdx == 0) a1.key.compareTo(a2.key)
            else sortedMaxScoreIdx
        }
        .map { it.key }
        .take(5)
        .toList()
}

fun deleteOneBridgeAndMe(
    user: String,
    usersScore: MutableMap<String, Int>,
    friendsRelation: MutableMap<String, MutableSet<String>>

): MutableMap<String, Int> {
    friendsRelation[user]!!.forEach { friend ->
        usersScore.remove(friend)
    }
    usersScore.remove(user)

    return usersScore
}


fun initializeFriendsRelation (
    friends: List<List<String>>,
): MutableMap<String, MutableSet<String>> {
    val friendsRelation = mutableMapOf<String, MutableSet<String>>()

    friends.forEach { relation ->
        var user1 = friendsRelation[relation[0]]
        var user2 = friendsRelation[relation[1]]

        if (user1.isNullOrEmpty()) {
            friendsRelation[relation[0]] = mutableSetOf(relation[1])
        } else {
            user1.add(relation[1])
        }

        if (user2.isNullOrEmpty()) {
            friendsRelation[relation[1]] = mutableSetOf(relation[0])
        } else {
            user2.add(relation[0])
        }
    }

    return friendsRelation
}


fun scoreMutualfriends(
    user: String,
    friendsRelation : MutableMap<String, MutableSet<String>>,
    usersScore : MutableMap<String, Int>,
): MutableMap<String, Int> {
    val userRelation = friendsRelation[user]

    for (friend in userRelation!!) {
        val userFriendRelation = friendsRelation[friend]
        if (userFriendRelation.isNullOrEmpty()) continue

        userFriendRelation.forEach {fr ->
            usersScore[fr] = usersScore.getOrDefault(fr, 0) + 10
        }
    }

    return usersScore
}

fun scoreVisitedUser(
    visitors: List<String>,
    usersScore : MutableMap<String, Int>,
): MutableMap<String, Int> {
    visitors.forEach { visitor ->
        usersScore[visitor] = usersScore.getOrDefault(visitor, 0) + 1
    }

    return usersScore
}
