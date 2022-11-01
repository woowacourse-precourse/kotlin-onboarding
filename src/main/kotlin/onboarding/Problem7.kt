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

fun getFriendsFriendList(friends: List<List<String>>, friendsList: List<String>, user: String): List<String> {
    val friendsFriendList: MutableList<String> = mutableListOf()
    for (i in friends) {
        if (friendsList.contains(i[0])) {
            if (i[1] != user) {
                friendsFriendList.add(i[1])
            }
        }
        if (friendsList.contains(i[1])) {
            if (i[0] != user) {
                friendsFriendList.add(i[0])
            }
        }
    }
    return friendsFriendList
}

fun getSortedScore(
    userList: List<String>,
    friendsFriendList: List<String>,
    visitors: List<String>,
    friendsList: List<String>
): List<String> {
    val score = MutableList(userList.size) { 0 }
    var result = mutableListOf<Pair<String, Int>>()

    friendsFriendList.forEach { it ->
        score[userList.indexOf(it)] += 10
    }
    visitors.forEach { it ->
        score[userList.indexOf(it)] += 1
    }
    friendsList.forEach { it ->
        score[userList.indexOf(it)] = 0
    }

    for (i in score.indices) {
        if (score[i] != 0) result.add(userList[i] to score[i])
    }

    result.sortedWith(compareBy({ it.first }, { it.second }))
    return result.map { it.first }.toList()
}