package onboarding


//user와 직접적인 칭구들 배열 생성 -> user[ friend1 : List<> , friend2 : List<>  ]
//해당 칭구들의 직접적인 친구들 리스트 생성
//resultList 만들어 칭구들의 점수를 표기 Map<String,Int> 입장 조건 : key값이 있으면 점수 추가 없으면 새로 추가
//visitor는 이미 user의 실제 칭구면 continue, 아니면 위와 동일하게 동작

fun setUserDirectFriendList(friends: List<List<String>>, user: String): MutableList<String> {
    val userDirectFriendList = mutableListOf<String>()
    friends.forEach { friendList ->
        if (friendList[0] == user) {
            userDirectFriendList.add(friendList[1])
        } else if (friendList[1] == user) {
            userDirectFriendList.add(friendList[0])
        }
    }
    println("직접적 친구 : $userDirectFriendList")
    return userDirectFriendList
}

fun setVisitValueList(
    visitors: List<String>, friendPointMap: MutableMap<String, Int>, userDirectFriendList: MutableList<String>
) {
    visitors.forEach { friend ->
        if (friendPointMap.containsKey(friend)) friendPointMap[friend] = friendPointMap.getValue(friend) + 1
        else if (!userDirectFriendList.contains(friend)) friendPointMap[friend] = 1
    }
    println("방문자들에게 점수 부여 $friendPointMap")
}

fun setFriendPointList(
    userDirectFriendList: MutableList<String>, friends: List<List<String>>, user: String
): MutableMap<String, Int> {
    val friendPointMap = mutableMapOf<String, Int>()
    userDirectFriendList.forEach { directFriend ->
        friends.forEach { friend ->
            if (directFriend == friend[0] && friendPointMap.containsKey(friend[1])) {
                friendPointMap[friend[1]] = friendPointMap.getValue(friend[1]) + 10
            } else if (directFriend == friend[0] && !friendPointMap.containsKey(friend[1])) {
                friendPointMap[friend[1]] = 10
            } else if (directFriend == friend[1] && friendPointMap.containsKey(friend[0])) {
                friendPointMap[friend[0]] = friendPointMap.getValue(friend[0]) + 10
            } else if (directFriend == friend[1] && !friendPointMap.containsKey(friend[0])) {
                friendPointMap[friend[0]] = 10
            }
        }
    }
    println("친구의 친구들에게 점수 부여 $friendPointMap")
    return friendPointMap
}

fun solution7(
    user: String, friends: List<List<String>>, visitors: List<String>
): List<String> {
    val userDirectFriendList = setUserDirectFriendList(friends, user)
    val friendPointMap = setFriendPointList(userDirectFriendList, friends, user)
    setVisitValueList(visitors, friendPointMap, userDirectFriendList)
    removeDirectFriends(friendPointMap, userDirectFriendList, user)
    val keySortedList =
        friendPointMap
            .toSortedMap()
            .toList()
            .sortedWith(compareBy<Pair<String, Int>> { it.second }.reversed())

    val answer = keySortedList
        .toMap()
        .keys
        .toList()

    if (answer.size > 5)
        return answer.take(5)

    return answer
}

fun removeDirectFriends(
    friendPointMap: MutableMap<String, Int>,
    userDirectFriendList: MutableList<String>,
    user: String
) {
    userDirectFriendList.forEach { friendPointMap.remove(it) }
    friendPointMap.remove(user)
}