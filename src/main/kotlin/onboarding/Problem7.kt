package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendList = mutableListOf<String>()
    val recommendedFriends = mutableMapOf<String, Int>()

    searchUserFriends(user, userFriendList, friends)
}

private fun searchUserFriends(user: String, userFriendList: MutableList<String>, relation: List<List<String>>) {
    for (list in relation) {
        if (list[0] == user) userFriendList.add(list[1])
        if (list[1] == user) userFriendList.add(list[0])
    }
}

