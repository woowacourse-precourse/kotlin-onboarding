package onboarding

var score = mutableMapOf<String, Int>()

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    score = mutableMapOf()
    val recommendationList = findFriends(0, friends, mutableMapOf())
    val userFriendList = recommendationList.remove(user) ?: mutableSetOf()
    val score = mutableMapOf<String, Int>()

    containVisitors(0, userFriendList, visitors, score)
    checkFriendList(0, user, userFriendList, recommendationList, score)

    return sortScore(score)
}

fun findFriends(
    index: Int,
    friends: List<List<String>>,
    friendList : MutableMap<String, MutableSet<String>>
) : MutableMap<String, MutableSet<String>> {
    if (index == friends.size) {
        return friendList
    }
    val (first, second) = friends[index]
    val firstList = friendList[first] ?: mutableSetOf()
    val secondList = friendList[second] ?: mutableSetOf()

    friendList.put(first, firstList.also { firstList.add(second) })
    friendList.put(second, secondList.also { secondList.add(first) })

    return findFriends(index + 1, friends, friendList)
}

fun checkFriendList(
    index: Int,
    user: String,
    userFriendList: MutableSet<String>,
    recommendationList : Map<String, Set<String>>,
    score : MutableMap<String, Int>
) {
    if (index == recommendationList.size) {
        return
    }
    val friend = recommendationList.entries

    if (!friend.elementAt(index).value.contains(user)) {
        val userName = friend.elementAt(index).key
        val userList = friend.elementAt(index).value
        containFriend(0, userName, userList, userFriendList, score)
    }
    return checkFriendList(index + 1, user, userFriendList, recommendationList, score)
}

fun containFriend(
    index: Int,
    userName: String,
    userList: Set<String>,
    userFriendList: MutableSet<String>,
    score: MutableMap<String, Int>
) {
    if (index == userFriendList.size) {
        return
    }
    val friendName = userFriendList.elementAt(index)

    if (userList.contains(friendName)) {
        getFriendPoint(userName, score)
    }
    return containFriend(index + 1, userName, userList, userFriendList, score)
}

fun getFriendPoint(key: String, score: MutableMap<String, Int>) {
    if (score.containsKey(key)) {
        score[key] = score[key]?.plus(10) ?: 0
        return
    }
    score.put(key, 10)
    return
}

fun containVisitors(
    index: Int,
    userList: Set<String>,
    visitors: List<String>,
    score: MutableMap<String, Int>
) {
    if (index == visitors.size) {
        return
    }
    val visitor = visitors[index]

    if (userList.contains(visitor)) {
        return containVisitors(index + 1, userList, visitors, score)
    }
    val addedScore = getVisitorPoint(visitor, score)
    return containVisitors(index + 1, userList, visitors, addedScore)
}

fun getVisitorPoint(visitor: String, score: MutableMap<String, Int>) : MutableMap<String, Int> {
    if (score.containsKey(visitor)) {
        score[visitor] = score[visitor]?.plus(1) ?: 0
        return score
    }
    score.put(visitor, 1)
    return score
}

fun sortScore(score: MutableMap<String, Int>): List<String> {
    val sortedScore =
        score.toList().sortedWith(compareBy({ -it.second }, { it.first })).map { it.first }

    if (score.size > 5) {
        return sortedScore.subList(0, 5)
    }
    return sortedScore
}