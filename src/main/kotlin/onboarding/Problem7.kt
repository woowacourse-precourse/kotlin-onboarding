package onboarding

var friendList = mutableMapOf<String, MutableSet<String>>()
var score = mutableMapOf<String, Int>()
var friendResult = mutableSetOf<String>()

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    friendList = mutableMapOf()
    score = mutableMapOf()
    friendResult = mutableSetOf()

    findFriends(0, friends)
    val userFriendList = friendList.remove(user) ?: mutableSetOf()

    findUserFriend(0, userFriendList)
    containVisitors(0, userFriendList, visitors)
    checkFriendList(0, user, userFriendList)

    return sortScore()
}

fun findFriends(index: Int, friends: List<List<String>>) {
    if (index == friends.size) {
        return
    }
    val (first, second) = friends[index]
    val firstList = friendList[first] ?: mutableSetOf()
    val secondList = friendList[second] ?: mutableSetOf()

    friendList.put(first, firstList.also { firstList.add(second) })
    friendList.put(second, secondList.also { secondList.add(first) })

    return findFriends(index + 1, friends)
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
        friendResult.add(userFriend)
    }
}

fun checkFriendList(index : Int, user : String, userFriendList: MutableSet<String>) {
    if (index == friendList.size) {
        return
    }
    val friend = friendList.entries

    if (!friend.elementAt(index).value.contains(user)) {
        hasFriend(0, friend.elementAt(index).key, friend.elementAt(index).value, userFriendList)
    }
    return checkFriendList(index + 1, user, userFriendList)
}

fun hasFriend(index : Int, userName : String, userList : Set<String>, userFriendList :  MutableSet<String>) {
    if (index == userFriendList.size) {
        return
    }
    val friendName = userFriendList.elementAt(index)

    if (userList.contains(friendName)) {
        getFriendPoint(userName)
    }
    return hasFriend(index + 1, userName, userList, userFriendList)
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

fun sortScore() : List<String> {
    val sortedScore = score.toList().sortedWith(compareBy ({-it.second}, {it.first})).map { it.first }

    if (score.size > 5) {
        return sortedScore.subList(0, 5)
    }
    return sortedScore
}