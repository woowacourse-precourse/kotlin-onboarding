package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {

    val userPointHashMap: HashMap<String, Int> = HashMap()
    val userHashSet: HashSet<String> = HashSet()

    friends.map {
        if (it[0] == user) userHashSet.add(it[1])
        if (it[1] == user) userHashSet.add(it[0])
    }

    friends.map {
        val notFollower: String = when {
            it[0] in userHashSet && user != it[1] -> it[1]
            it[1] in userHashSet && user != it[0] -> it[0]
            else -> return@map
        }
        userPointHashMap[notFollower] = userPointHashMap
            .getOrDefault(notFollower, 0) + 10
    }

    visitors
        .filterNot { it in userHashSet }
        .map { userPointHashMap[it] = userPointHashMap
            .getOrDefault(it + 1, 1) + 1
        }

    val recommendFriend = userPointHashMap.asSequence()
        .sortedWith { firstSorted, secondSorted ->
            val sameUser = firstSorted.key.compareTo(secondSorted.key)
            val samePoints = secondSorted.value.compareTo(firstSorted.value)

            if (samePoints == 0) sameUser else samePoints
        }
        .map { it.key }
        .take(5)
        .toList()

    return recommendFriend
}

