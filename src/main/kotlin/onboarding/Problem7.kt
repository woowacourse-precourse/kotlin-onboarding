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

private fun getMutualFriendsList(
    friends: List<List<String>>,
    userFriendsList: MutableList<String>
): MutableList<String> {
    val mutualFriendsList: MutableList<String> = mutableListOf()

    for (i in friends.indices) {
        if (userFriendsList.contains(friends[i][0])) {
            mutualFriendsList.add(friends[i][1])
        } else if (userFriendsList.contains(friends[i][1])) {
            mutualFriendsList.add(friends[i][0])
        }
    }
    return mutualFriendsList
}

private fun calculateFriendsPoint(
    mutualFriendsList: MutableList<String>
): MutableMap<String, Int> {
    val friendsMapWithMutual: MutableMap<String, Int> = mutableMapOf()

    for (i in mutualFriendsList.indices) {
        if (friendsMapWithMutual.contains(mutualFriendsList[i])) {
            friendsMapWithMutual[mutualFriendsList[i]] =
                friendsMapWithMutual.getValue(mutualFriendsList[i]) + 10
        } else {
            friendsMapWithMutual[mutualFriendsList[i]] = 0
        }
    }
    return friendsMapWithMutual
}
