package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun friendList(user: String, friends: List<List<String>>): MutableSet<String> {
    val friend = mutableSetOf<String>()
    friends.forEach {
        when (user) {
            it[0] -> friend.add(it[1])
            it[1] -> friend.add(it[0])
        }
    }
    return friend
}

fun friendOfFriend(user: String, friends: List<List<String>>): MutableMap<String, Int> {
    val notFriend = friends.toMutableList()
    val friend = friendList(user, friends)
    val friendOfFriend = mutableMapOf<String, Int>()
    friends.forEach {
        when {
            it[0] in friend && it[1] in friend -> notFriend.remove(it)
        }
    }
    notFriend.forEach {
        when {
            it[0] in friend && user != it[1] -> friendOfFriend[it[1]] = friendOfFriend.getOrDefault(it[1], 0) + 10
            it[1] in friend && user != it[0] -> friendOfFriend[it[0]] = friendOfFriend.getOrDefault(it[0], 0) + 10
        }
    }
    return friendOfFriend
}

fun visitedList(user: String, friends: List<List<String>>, visitors: List<String>): MutableMap<String, Int> {
    val friend = friendList(user, friends)
    val friendOfFriend = friendOfFriend(user, friends)
    visitors.forEach {
        when (it) {
            !in friend -> friendOfFriend[it] = friendOfFriend.getOrDefault(it, 0) + 1
        }
    }
    return friendOfFriend.toSortedMap()
}