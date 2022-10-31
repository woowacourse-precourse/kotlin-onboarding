package onboarding

import java.lang.Integer.min

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendsMap = mutableMapOf<String, MutableList<String>>()
    val users = mutableMapOf<String, Int>()

    setFriendsMap(friends, friendsMap, users)
    setVisitorScore(visitors, users)
    setFriendsScore(friendsMap, users, user)

    return getRecommendedUsers(users, user)
}

fun setFriendsMap(
    friends: List<List<String>>,
    friendsMap: MutableMap<String, MutableList<String>>,
    users: MutableMap<String, Int>
) {
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
}

fun setVisitorScore(visitors: List<String>, users: MutableMap<String, Int>) {
    visitors.forEach {
        if (users.containsKey(it)) {
            users[it] = users[it]!! + 1
        } else {
            users[it] = 0
        }
    }
}

fun setFriendsScore(
    friendsMap: MutableMap<String, MutableList<String>>,
    users: MutableMap<String, Int>,
    user: String
) {
    friendsMap[user]?.forEach { friend ->
        users[friend] = 0
        friendsMap[friend]?.forEach {
            users[it] = users[it]!! + 10
        }
    }
}

fun getRecommendedUsers(users: MutableMap<String, Int>, user: String): List<String> {
    val recommendedUsers = users.filter { (k, v) ->
        v > 0 && k != user
    }.toList().sortedByDescending {
        it.second
    }.map { (k, _) ->
        k
    }
    return recommendedUsers.subList(0, min(5, recommendedUsers.size))
}