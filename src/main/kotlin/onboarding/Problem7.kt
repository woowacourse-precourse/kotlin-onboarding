package onboarding

private val friendsRelation = mutableMapOf<String, MutableSet<String>>()
private var usersScore = mutableMapOf<String, Int>()
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    initializeFriendsRelation(user, friends)
    scoreMutualfriends(user)
    scoreVisitedUser(visitors)
    deleteOneBridgeAndMe(user)

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

fun deleteOneBridgeAndMe(user: String) {
    val userRelation = friendsRelation[user]
    if (userRelation.isNullOrEmpty()) return

    userRelation.forEach { friend ->
        usersScore.remove(friend)
    }
    usersScore.remove(user)
}


fun initializeFriendsRelation(user : String, friends: List<List<String>>) {
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
}


fun scoreMutualfriends(user: String) {
    val userRelation = friendsRelation[user]
    if (userRelation.isNullOrEmpty()) return

    for (friend in userRelation) {
        val userFriendRelation = friendsRelation[friend]
        if (userFriendRelation.isNullOrEmpty()) continue

        userFriendRelation.forEach {fr ->
            usersScore[fr] = usersScore.getOrDefault(fr, 0) + 10
        }
    }
}

fun scoreVisitedUser(visitors: List<String>) {
    visitors.forEach { visitor ->
        usersScore[visitor] = usersScore.getOrDefault(visitor, 0) + 1
    }
}

fun main() {

    val user = "mrko"

    val friends = mutableListOf<MutableList<String>>()
    friends.add(mutableListOf("donut", "andole"))
    friends.add(mutableListOf("donut", "jun"))
    friends.add(mutableListOf("donut", "mrko"))
    friends.add(mutableListOf("shakevan", "andole"))
    friends.add(mutableListOf("shakevan", "jun"))
    friends.add(mutableListOf("shakevan", "mrko"))

    val visitors = mutableListOf("bedi", "bedi", "donut", "bedi", "shakevan")

    println(solution7(user, friends, visitors))
}
