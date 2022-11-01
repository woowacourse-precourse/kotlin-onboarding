package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {

    val userPointHashMap: HashMap<String, Int> = HashMap()
    val userHashSet: HashSet<String> = HashSet()

    friends.map {
        val userInPrimaryArray: Boolean = (it[PRIMARY_ARRAY] == user)
        val userInSecondArray: Boolean = (it[SECOND_ARRAY] == user)

        if (userInPrimaryArray) userHashSet.add(it[SECOND_ARRAY])
        if (userInSecondArray) userHashSet.add(it[PRIMARY_ARRAY])
    }

    friends.map {
        val notFollowerInPrimaryArray: Boolean =
            (it[PRIMARY_ARRAY] in userHashSet && user != it[SECOND_ARRAY])
        val notFollowerInSecondArray: Boolean =
            (it[SECOND_ARRAY] in userHashSet && user != it[PRIMARY_ARRAY])

        val notFollower: String = when {
            notFollowerInPrimaryArray -> it[SECOND_ARRAY]
            notFollowerInSecondArray -> it[PRIMARY_ARRAY]
            else -> return@map
        }
        userPointHashMap[notFollower] = userPointHashMap
            .getOrDefault(notFollower, 0) + 10
    }

    visitors
        .filterNot { it in userHashSet }
        .map {
            userPointHashMap[it] = userPointHashMap
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

const val PRIMARY_ARRAY = 0
const val SECOND_ARRAY = 1
