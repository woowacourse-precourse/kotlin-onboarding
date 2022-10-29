package onboarding

val friendList = mutableMapOf<String, MutableSet<String>>()
val score = mutableMapOf<String, Int>()

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    findFriends(0, friends)
    val userFriendList = friendList.remove(user) ?: mutableSetOf()

    findUserFriend(0, userFriendList)
    containVisitors(0, userFriendList, visitors)

    return sortScore()
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

fun containsUserFriend(key: String, userFriend: String) {
    if (friendList[key]?.contains(userFriend) ?: false) {
        getFriendPoint(key)
    }
}

fun getFriendPoint(key: String) {
    if (score.containsKey(key)) {
        score[key] = score[key]?.plus(10) ?: 0
        return
    }
    score.put(key, 10)
    return
}

fun containVisitors(index: Int, userList: Set<String>, visitors: List<String>) {
    if (index == visitors.size) {
        return
    }
    val visitor = visitors[index]

    if (!userList.contains(visitor)) {
        getVisitorPoint(visitor)
    }
    return containVisitors(index + 1, userList, visitors)
}

fun getVisitorPoint(visitor: String) {
    if (score.containsKey(visitor)) {
        score[visitor] = score[visitor]?.plus(1) ?: 0
        return
    }
    score.put(visitor, 1)
    return
}

fun sortScore(): List<String> {
    val sortedScore = score.toList().sortedByDescending { it.second }.map { it.first }

    if (score.size > 5) {
        return sortedScore.subList(0, 5)
    }
    return sortedScore
}