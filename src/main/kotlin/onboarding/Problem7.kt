package onboarding

import java.lang.Integer.min
import java.util.*

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendsMap = mutableMapOf<String, MutableList<String>>()
    val users = mutableMapOf<String, Int>()
    friends.forEach { friend ->
        val (a, b) = friend
        friendsMap[a]?.add(b) ?: run {
            friendsMap[a] = mutableListOf(b)
        }
        friendsMap[b]?.add(a) ?: run {
            friendsMap[b] = mutableListOf(a)
        }
        users[a] = 0
        users[b] = 0
    }

    visitors.forEach {
        if (users.containsKey(it)) {
            users[it] = users[it]!! + 1
        } else {
            users[it] = 0
        }
    }

    friendsMap[user]?.forEach { friend ->
        users[friend] = 0
        friendsMap[friend]?.forEach {
            users[it] = users[it]!! + 10
        }
    }

    val result = users.filter { (k, v) ->
        v > 0 && k != user
    }.toList().sortedByDescending {
        it.second
    }.map { (k, _) ->
        k
    }
    return result.subList(0, min(5, result.size))
}

fun main() {
    val users = sortedMapOf<Char, Int>(Collections.reverseOrder())
    users['c'] = 2
    users['b'] = 1
    users['a'] = 3

    println(users.toString())
}