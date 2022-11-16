package onboarding

private val userPointHashMap: HashMap<String, Int> = HashMap()
private val userHashSet: HashSet<String> = HashSet()

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {

    createFriendship(user, friends)
    updateFollowerPoint(user, friends)
    updateVisitorPoint(visitors)
    return createAcquaintance()
}

fun createFriendship(user: String, friends: List<List<String>>) {
    friends.forEach {
        val userInPrimaryArray: Boolean = (it[FIRST_COLUMNS] == user)
        val userInSecondArray: Boolean = (it[SECOND_COLUMNS] == user)

        if (userInPrimaryArray) userHashSet.add(it[SECOND_COLUMNS])
        if (userInSecondArray) userHashSet.add(it[FIRST_COLUMNS])
    }
}

fun updateFollowerPoint(user: String, friends: List<List<String>>) {
    friends.forEach {
        val notFollowerInPrimaryArray: Boolean =
            (it[FIRST_COLUMNS] in userHashSet && user != it[SECOND_COLUMNS])
        val notFollowerInSecondArray: Boolean =
            (it[SECOND_COLUMNS] in userHashSet && user != it[FIRST_COLUMNS])

        val notFollower: String = when {
            notFollowerInPrimaryArray -> it[SECOND_COLUMNS]
            notFollowerInSecondArray -> it[FIRST_COLUMNS]
            else -> return@forEach
        }
        userPointHashMap[notFollower] = userPointHashMap
            .getOrDefault(notFollower, DEFAULT_POINT_ZERO) + ACQUAINTANCE_POINT_TEN
    }
}

fun updateVisitorPoint(visitors: List<String>) {
    visitors
        .filterNot { it in userHashSet }
        .map {
            userPointHashMap[it] = userPointHashMap
                .getOrDefault(it + 1, VISITOR_DEFAULT_POINT_ONE) + VISITOR_POINT_ONE
        }
}


fun createAcquaintance(): List<String> {
    val recommendFriend = userPointHashMap.asSequence()
        .sortedWith { firstSorted, secondSorted ->
            val sameUser = firstSorted.key.compareTo(secondSorted.key)
            val samePoints = secondSorted.value.compareTo(firstSorted.value)

            if (samePoints == 0) sameUser else samePoints
        }
        .map { it.key }
        .take(FIVE_ELEMENTS_FROM_FRONT)
        .toList()

    return recommendFriend

}

const val FIRST_COLUMNS = 0
const val SECOND_COLUMNS = 1
const val VISITOR_DEFAULT_POINT_ONE = 1
const val VISITOR_POINT_ONE = 1
const val DEFAULT_POINT_ZERO = 0
const val ACQUAINTANCE_POINT_TEN = 10
const val FIVE_ELEMENTS_FROM_FRONT = 5
