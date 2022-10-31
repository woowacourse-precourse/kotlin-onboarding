package onboarding

fun getUserFriends(
    user: String,
    friends: List<List<String>>
): List<String> {
    return friends.filter { it.contains(user) }
        .map { it[it.indexOf(user) xor 1] }
        .toList()
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val resultMap = hashMapOf<String, Int>()
    val userFriends = getUserFriends(user, friends)

    userFriends.flatMap { userFriend -> getUserFriends(userFriend, friends) }
        .forEach { acquaintance ->
            if (resultMap[acquaintance] == null) resultMap[acquaintance] = 0
            else resultMap[acquaintance]!!.plus(10)
        }

    for (visitor in visitors) {
        if (resultMap[visitor] == null) resultMap[visitor] = 0
        else resultMap[visitor]!!.plus(1)
    }

    return resultMap.toList().sortedBy { mapEntry -> mapEntry.second }
        .filter { mapEntry ->
            !userFriends.contains(mapEntry.first) && mapEntry.first != user
        }
        .map { mapEntry -> mapEntry.first }.take(5)
}
