package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val result: List<String>
    val resultMap = mutableMapOf<String, Int>()

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
    friendsMap[user]?.forEach { friend ->
        requireNotNull(friendsMap[friend]).filterNot { it == user }.forEach { friendOfFriend ->
            if (resultMap.containsKey(friendOfFriend)) {
                resultMap[friendOfFriend] = resultMap.getValue(friendOfFriend) + 10
            } else {
                resultMap[friendOfFriend] = 10
            }
        }
    }

    visitors.filterNot {
        friendsMap[user]?.contains(it) ?: false
    }.forEach {
        if (resultMap[it] == null) {
            resultMap[it] = 1
        } else {
            resultMap[it] = resultMap.getValue(it) + 1
        }
    }

    result = resultMap.toList().sortedByDescending { it.second }.map { it.first }.take(5)

    return result
}
