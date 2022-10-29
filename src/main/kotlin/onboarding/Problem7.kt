package onboarding

val friendList = mutableMapOf<String, MutableSet<String>>()

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun findUserFriend(index: Int, userFriendList: MutableSet<String>) {
    if (index == userFriendList.size) {
        return
    }
    checkUserFriends(0, friendList.keys, userFriendList.elementAt(index))
    return findUserFriend(index + 1, userFriendList)
}

fun findUserFriend(index: Int, userFriendList: MutableSet<String>) {
    if (index == userFriendList.size) {
        return
    }
    checkUserFriends(0, friendList.keys, userFriendList.elementAt(index))
    return findUserFriend(index + 1, userFriendList)
}

fun checkUserFriends(index: Int, userList: Set<String>, userFriend: String) {
    if (index == userList.size) {
        return
    }
    containsUserFriend(userList.elementAt(index), userFriend)
    return checkUserFriends(index + 1, userList, userFriend)
}