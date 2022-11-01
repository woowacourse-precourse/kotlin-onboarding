package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var resultMap = mutableMapOf<String, Int>()

    val friendsMap: MutableMap<String, MutableList<String>> = getFriendsRelationshipMap(friends)
    resultMap = getFriendsOfFriendsPoint(user, resultMap, friendsMap)
    resultMap = getVisitorsPoint(resultMap, visitors)

    return translateResultMapToResultList(user,resultMap, friendsMap)
}

private fun getFriendsRelationshipMap(friends: List<List<String>>): MutableMap<String, MutableList<String>> {
    val friendsMap = mutableMapOf<String, MutableList<String>>()
    friends.forEach {
        if (friendsMap.containsKey(it[0])) {
            requireNotNull(friendsMap[it[0]]).add(it[1])
        } else {
            friendsMap[it[0]] = mutableListOf(it[1])
        }

        if (friendsMap.containsKey(it[1])) {
            requireNotNull(friendsMap[it[1]]).add(it[0])
        } else {
            friendsMap[it[1]] = mutableListOf(it[0])
        }
    }
    return friendsMap
}

private fun getFriendsOfFriendsPoint(
    user: String,
    resultMap: MutableMap<String, Int>,
    friendsMap: MutableMap<String, MutableList<String>>
): MutableMap<String, Int> {
    friendsMap[user]?.forEach { friend ->
        requireNotNull(friendsMap[friend]).forEach { friendOfFriend ->
            if (resultMap.containsKey(friendOfFriend)) {
                resultMap[friendOfFriend] = resultMap.getValue(friendOfFriend) + 10
            } else {
                resultMap[friendOfFriend] = 10
            }
        }
    }
    return resultMap
}

private fun getVisitorsPoint(resultMap: MutableMap<String, Int>, visitors: List<String>): MutableMap<String, Int> {
    visitors.forEach {
        if (resultMap[it] == null) {
            resultMap[it] = 1
        } else {
            resultMap[it] = resultMap.getValue(it) + 1
        }
    }
    return resultMap
}

private fun translateResultMapToResultList(
    user: String,
    resultMap: MutableMap<String, Int>,
    friendsMap: MutableMap<String, MutableList<String>>
): List<String> {
    return resultMap.filterNot { it.key == user || friendsMap[user]?.contains(it.key) ?: false }
        .toList()
        .sortedBy { it.first }
        .sortedByDescending { it.second }
        .map { it.first }
        .take(5)
}