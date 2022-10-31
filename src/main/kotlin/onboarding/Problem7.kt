package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    return emptyList()
}

fun checkUserFriend(relationship: List<String>, userName: String): String? {
    if (relationship[0] == userName && relationship[1] == userName) return null

    return when (userName) {
        relationship[0] -> relationship[1]
        relationship[1] -> relationship[0]
        else -> null
    }
}

fun getUserFriends(name: String, allFriendsList: List<List<String>>): Set<String> {
    val userFriends = mutableSetOf<String>()
    for (relationship in allFriendsList) {
        checkUserFriend(relationship, name)?.let { friendName -> userFriends.add(friendName) }
    }
    return userFriends
}
