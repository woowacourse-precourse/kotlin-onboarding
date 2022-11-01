package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendHashSet = hashSetOf<String>()
    val friendScoreHashMap = hashMapOf<String, Int>()

    friends.forEach() {
        when (user) {
            it[0] -> userFriendHashSet.add(it[1])
            it[1] -> userFriendHashSet.add(it[0])
        }
    }

    friends.forEach {
        val stranger = when {
            (it[0] in userFriendHashSet) && (user != it[1]) -> it[1]
            (it[1] in userFriendHashSet) && (user != it[0]) -> it[0]
            else -> return@forEach
        }
        friendScoreHashMap[stranger] = friendScoreHashMap.getOrDefault(stranger, 0) + 10
    }

    visitors
        .filterNot { it in userFriendHashSet }
        .forEach() { friendScoreHashMap[it] = friendScoreHashMap.getOrDefault(it + 1, 1) + 1 }

    return friendScoreHashMap.asSequence()
        .sortedWith { p1, p2 ->
            val scoreSame = p2.value.compareTo(p1.value)
            val keySame = p1.key.compareTo(p2.key)

            if (scoreSame != 0) {
                scoreSame
            } else {
                keySame
            }
        }
        .map { it.key }
        .take(5)
        .toList()
}
