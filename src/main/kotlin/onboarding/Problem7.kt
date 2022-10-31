package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

private fun getUserFriendsList(userId: String, friends: List<List<String>>): MutableList<String> {
    val userFriendsList: MutableList<String> = mutableListOf()

    for (i in friends.indices) {
        if (friends[i][0] == userId) {
            userFriendsList.add(friends[i][1])
        } else if (friends[i][1] == userId) {
            userFriendsList.add(friends[i][0])
        }
    }
    return userFriendsList
}