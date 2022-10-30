package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val score = mutableMapOf<String, Int>()

    val userFriends = mutableSetOf<String>()
    friends.forEach {
        if (it[0] == user) {
            userFriends.add(it[1])
        } else if (it[1] == user) {
            userFriends.add(it[0])
        }
    }

    friends.forEach {
        if ((it[0] in userFriends) && (it[1] != user)) {
            score[it[1]] = score[it[1]]?.plus(10) ?: 10
        } else if ((it[1] in userFriends) && it[0] != user) {
            score[it[0]] = score[it[0]]?.plus(10) ?: 10
        }
    }

    visitors.forEach {
        score[it] = score[it]?.plus(1) ?: 1
    }

    val res = mutableListOf<Pair<String, Int>>()
    score.forEach {
        if ((it.key in userFriends).not())
            res.add(Pair(it.key, it.value))
    }

    res.sortWith { p1, p2 ->
        return@sortWith if (p1.second != p2.second) {
            -p1.second.compareTo(p2.second)
        } else {
            p1.first.compareTo(p2.first)
        }
    }

    return res.chunked(5)[0].map { it.first }

}
