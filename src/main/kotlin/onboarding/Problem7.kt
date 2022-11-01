package onboarding

private fun getUserFriends(
    user: String,
    friends: List<List<String>>
): List<String> {
    return friends.filter { it.contains(user) }
        .map { it[it.indexOf(user) xor 1] }
        .toList()
}

private fun calculateAcquaintanceScore(
    userFriends: List<String>,
    friends: List<List<String>>,
    resultMap: HashMap<String, Int>
) {
    userFriends.flatMap { userFriend -> getUserFriends(userFriend, friends) }
        .forEach { acquaintance ->
            resultMap[acquaintance] = resultMap[acquaintance]?.plus(10) ?: 0
        }
}

private fun calculateVisitorScore(
    visitors: List<String>,
    resultMap: HashMap<String, Int>
) {
    visitors.forEach { visitor ->
        resultMap[visitor] = resultMap[visitor]?.plus(1) ?: 0
    }
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val resultMap = hashMapOf<String, Int>()
    val userFriends = getUserFriends(user, friends)

    calculateAcquaintanceScore(userFriends, friends, resultMap)
    calculateVisitorScore(visitors, resultMap)

    return resultMap.toList().sortedByDescending { mapEntry -> mapEntry.second }
        .filter { mapEntry ->
            !userFriends.contains(mapEntry.first) && mapEntry.first != user
        }
        .map { mapEntry -> mapEntry.first }.take(5)
}



