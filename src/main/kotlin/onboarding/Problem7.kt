package onboarding

import java.lang.Math.abs

fun solution7(
        user: String,
        friends: List<List<String>>,
        visitors: List<String>
): List<String> {
    var friendsScoreList = friendNameSet(friends, visitors) // 사용자 아이디를 Key로 Value는 0인 HashMap 세팅
    friendsScoreList.remove(user)

    val knowFriendsNameList = knowFriendsSet(user, friends)  // 주어진 user와 친구인 사용자 리스트
    knowFriendsNameList.removeIf(String::isEmpty)

    friendsScoreList = updatePlus_10(friends, friendsScoreList, knowFriendsNameList)
    friendsScoreList = updatePlus_1(friendsScoreList, visitors)

    val sortMap = friendsScoreList.toList().sortedByDescending { it.second }.toMutableList()  // 점수 순으로 정렬

    val result = ArrayList<String>()

    for (set in sortMap) {
        if (set.second != 0 && !knowFriendsNameList.contains(set.first) && result.size < 5) {
            result.add(set.first)
        }
    }

    return result
}

fun updatePlus_1(friendsScoreList: HashMap<String, Int>, visitors: List<String>): HashMap<String, Int> {
    for (name in visitors) {
        var score = friendsScoreList[name]!!
        friendsScoreList.replace(name, ++score)
    }
    return friendsScoreList
}

fun updatePlus_10(friends: List<List<String>>, friendsScoreList: HashMap<String, Int>, knowFriendsNameList: ArrayList<String>): HashMap<String, Int> {
    for (friendName in knowFriendsNameList) {
        for (i in friends.indices) {
            if (friends[i].contains(friendName)) {
                val index = friends[i].indexOf(friendName)
                if (friendsScoreList.contains(friends[i][abs(index - 1)])) {
                    friendsScoreList.replace(friends[i][abs(index - 1)], 10)
                }
            }
        }
    }
    return friendsScoreList
}

fun knowFriendsSet(user: String, friends: List<List<String>>): ArrayList<String> {
    val friendsIterator = friends.iterator()
    val knowFriendsNameList = ArrayList<String>()

    while (friendsIterator.hasNext()) {
        knowFriendsNameList.add(addKnowFriends(user, friendsIterator.next()))
    }
    return knowFriendsNameList
}

fun addKnowFriends(user: String, next: List<String>): String {
    if (next.indexOf(user) != -1) {
        return next[1 - abs(next.indexOf(user))]
    }
    return ""
}

fun friendNameSet(friends: List<List<String>>, visitors: List<String>): HashMap<String, Int> {
    var friendsNameList = HashMap<String, Int>()
    val friendsIterator = friends.iterator()
    val visitorsIterator = visitors.iterator()

    while (friendsIterator.hasNext()) {
        val list = friendsIterator.next()
        friendsNameList.put(list[0], 0)
        friendsNameList.put(list[1], 0)
    }
    while (visitorsIterator.hasNext()) {
        friendsNameList.put(visitorsIterator.next(), 0)
    }
    return friendsNameList
}
