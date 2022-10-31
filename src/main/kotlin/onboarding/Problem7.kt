package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userList = getAllUserList(friends, visitors)
    val gradeTable = MutableList(userList.size) { 0 }
    val friendsList = getFriendsList(friends, user)
    val friendsOfFriendsList = getFriendsListOfFriends(friends, friendsList, user)

    friendsOfFriendsList.forEach { item ->
        gradeTable[userList.indexOf(item)] += 10
    }
    visitors.forEach { item ->
        gradeTable[userList.indexOf(item)] += 1
    }
    friendsList.forEach { item ->
        gradeTable[userList.indexOf(item)] = 0
    }

    val answer = mutableListOf<Pair<String, Int>>()
    // 0점이 아닌 값들을 answer리스트에 추가
    for (i in gradeTable.indices) {
        if (gradeTable[i] != 0) answer.add(userList[i] to gradeTable[i])
    }

    // 점수순으로 먼저, 그다음 이름순 정렬
    return answer
        .sortedWith(compareBy({ -it.second }, { it.first }))
        .map { it.first }
        .take(5)
        .toList()
}

/**
 * 전체 유저의 리스트를 반환한다.
 */
fun getAllUserList(friends: List<List<String>>, visitors: List<String>): List<String> {
    val totalUserList = mutableListOf<String>()
    for (i in friends) {
        if (!totalUserList.contains(i[0])) {
            totalUserList.add(i[0])
        }
        if (!totalUserList.contains(i[1])) {
            totalUserList.add(i[1])
        }
    }
    for (i in visitors) {
        if (!totalUserList.contains(i)) {
            totalUserList.add(i)
        }
    }
    return totalUserList.toList()
}

/**
 * 유저와 이미 친구인 리스트를 반환한다.
 */
fun getFriendsList(friends: List<List<String>>, user: String): List<String> {
    val friendsList = mutableListOf<String>()
    for (i in friends) {
        if (i[0] == user) {
            friendsList.add(i[1])
            continue
        }
        if (i[1] == user) {
            friendsList.add(i[0])
        }
    }
    return friendsList.toList()
}

/**
 * 친구와 친구인 리스트를 반환한다.
 */
fun getFriendsListOfFriends(friends: List<List<String>>, friendsList: List<String>, user: String): List<String> {
    val friendsOfFriendsList = mutableListOf<String>()
    for (i in friends) {
        if (friendsList.contains(i[0]) && i[1] != user) {
            friendsOfFriendsList.add(i[1])
            continue
        }
        if (friendsList.contains(i[1]) && i[0] != user) {
            friendsOfFriendsList.add(i[0])
        }
    }
    return friendsOfFriendsList.toList()
}