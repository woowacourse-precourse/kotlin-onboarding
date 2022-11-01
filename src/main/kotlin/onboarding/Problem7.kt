package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var scores = initScore(user, friends)
    scores = updateScore(visitors, scores)
    return getBestFriends(scores)
}

fun getBestFriends(scores: MutableMap<String, Int>): MutableList<String> {
    val users = mutableListOf<Pair<Int, String>>()

    scores.forEach {
        users.add(Pair(it.value, it.key))
    }

    users.sortByDescending {
        it.first
    }

    val result = mutableListOf<String>()

    for(user in users) {
        result.add(user.second)
    }

    return result
}

fun updateScore(visitors: List<String>, scores: MutableMap<String, Int>): MutableMap<String, Int> {
    for(visitor in visitors) {
        scores[visitor] = scores[visitor]!!.plus(1)
    }
}

fun initScore(user: String, friends: List<List<String>>): MutableMap<String, Int> {
    val scores = mutableMapOf<String, Int>()

    for(friend in friends) {
        val user1 = friend[0]
        val user2 = friend[1]

        if(user1 == user) {
            scores[user2] = 10
        } else if(user2 == user) {
            scores[user1] = 10
        }
    }

    return scores
}