package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun getUserList(friends: List<List<String>>, visitors: List<String>): List<String> {
    val userList: MutableList<String> = mutableListOf()

    for (i in friends) {
        if (!userList.contains(i[0])) {
            userList.add(i[0])
        }
        if (!userList.contains(i[1])) {
            userList.add(i[1])
        }
    }

    for (i in visitors) {
        if (!userList.contains(i)) {
            userList.add(i)
        }
    }

    return userList
}

fun getFriendsList(friends: List<List<String>>, user: String): List<String> {
    val friendsList: MutableList<String> = mutableListOf()
    for (i: Int in friends.indices) {
        if (friends[i][1] == user) {
            friendsList.add(friends[i][0])
        }
    }
    return friendsList.toList()
}