package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val oldFriends = getOldFriends(user, friends)
    var scores = initScore(user, friends, oldFriends)
    scores = updateScore(visitors, scores, oldFriends)
    return getBestFriends(scores)
}

fun getBestFriends(scores: MutableMap<String, Int>): MutableList<String> {
    val users = mutableListOf<Pair<Int, String>>()

    scores.forEach {
        users.add(Pair(it.value, it.key))
    }

    users.sortedWith(compareBy({ -it.first }, { it.second }))

    val result = mutableListOf<String>()

    for (user in users) {
        if (user.first == 0) {
            break
        }

        result.add(user.second)

        if (result.size == 5) {
            break
        }
    }

    return result
}

fun updateScore(
    visitors: List<String>,
    scores: MutableMap<String, Int>,
    oldFriends: MutableSet<String>
): MutableMap<String, Int> {
    for (visitor in visitors) {
        if (oldFriends.contains(visitor)) {
            continue
        }

        if (scores[visitor] == null) {
            scores[visitor] = 0
        }

        scores[visitor] = scores[visitor]!!.plus(1)
    }
    return scores
}

fun initScore(user: String, friends: List<List<String>>, oldFriends: MutableSet<String>): MutableMap<String, Int> {
    val scores = mutableMapOf<String, Int>()

    for (friend in friends) {
        val user1 = friend[0]
        val user2 = friend[1]

        if (user1 == user || user2 == user) {
            continue
        }

        if (isValid(user1, user2, oldFriends)) {
            if (scores[user2] == null) {
                scores[user2] = 0
            }

            scores[user2] = scores[user2]!!.plus(10)
        }

        if (isValid(user2, user1, oldFriends)) {
            if (scores[user1] == null) {
                scores[user1] = 0
            }

            scores[user1] = scores[user1]!!.plus(10)
        }
    }

    return scores
}

fun isValid(user1: String, user2: String, oldFriends: MutableSet<String>): Boolean {
    return oldFriends.contains(user1) && !oldFriends.contains(user2)
}

fun getOldFriends(
    user: String,
    friends: List<List<String>>
): MutableSet<String> {
    val oldFriends = mutableSetOf<String>()

    for (friend in friends) {
        val user1 = friend[0]
        val user2 = friend[1]

        if (user1 == user) {
            oldFriends.add(user2)
        } else if (user2 == user) {
            oldFriends.add(user1)
        }
    }

    return oldFriends
}