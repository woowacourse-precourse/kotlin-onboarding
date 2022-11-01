package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    return listOf()
}

fun getFriendList(user: String, friends: List<List<String>>): HashSet<String> {
    val friendList = hashSetOf<String>()

    for (friend in friends) {
        when (user) {
            friend[0] -> friendList.add(friend[1])
            friend[1] -> friendList.add(friend[0])
        }
    }

    return friendList
}

fun countFriendScore(user: String, friends: List<List<String>>,
                     visitors: List<String>): HashMap<String, Int> {
    val countScoreMap = hashMapOf<String, Int>()
    val friendList = getFriendList(user, friends)

    for (friend in friends) {
        val relation = when {
            friend[0] in friendList && user != friend[1] -> friend[1]
            friend[1] in friendList && user != friend[0] -> friend[0]
            else -> continue
        }

        countScoreMap[relation] = countScoreMap.getOrDefault(relation, 0) + 10
    }

    for (visitor in visitors) {
        if (visitor in friendList)
            continue

        countScoreMap[visitor] = countScoreMap.getOrDefault(visitor, 0) + 1
    }

    return countScoreMap
}
