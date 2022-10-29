package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

private fun createFriendsMap(friendRelations: List<List<String>>): Map<String, List<String>> {
    val friendsMap = mutableMapOf<String, MutableList<String>>()

    friendRelations.forEach { relation ->
        val friendA = relation[0]
        val friendB = relation[1]

        friendsMap[friendA] = addFriend(friendsMap[friendA], friendB)
        friendsMap[friendB] = addFriend(friendsMap[friendB], friendA)
    }

    return friendsMap
}

private fun addFriend(friends: MutableList<String>?, newFriend: String): MutableList<String> {
    return (friends ?: mutableListOf()).apply {
        add(newFriend)
    }
}