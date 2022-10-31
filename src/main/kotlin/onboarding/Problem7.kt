package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var map: HashMap<String, Int> = setUniqueNumber(friends, user)
    var graph: Array<MutableList<String>> = addFriends(friends, user, map)
    var userFriends = HashMap<String, Int>()

    for (i in graph[map[user]!!]) {
        for (j in graph[map["$i"]!!]) {
            if (userFriends.containsKey("$j")) {
                continue
            }
            userFriends["$j"] = 10
        }
    }

    updateVisitUser(visitors, userFriends)

    for (i in graph[map[user]!!]) {
        if (userFriends.containsKey("$i")) {
            userFriends.remove("$i")
        }
    }

    var sortedList = userFriends.entries.sortedWith(compareByDescending<MutableMap.MutableEntry<String, Int>> { it.value }.thenBy { it.key })
    val result = mutableListOf<String>()

    for (i in 0 until 5) {
        try {
            result.add(sortedList[i].key)
        } catch (e : IndexOutOfBoundsException) {
        }
    }

    return result
}

fun updateVisitUser(visitors: List<String>, result: HashMap<String, Int>): HashMap<String, Int> {
    for (i in visitors.indices) {
        if (result.containsKey(visitors[i])) {
            result[visitors[i]] = result[visitors[i]]!! + 1
        } else {
            result[visitors[i]] = 1
        }
    }
    return result
}

fun setUniqueNumber(friends: List<List<String>>, user: String): HashMap<String, Int> {
    var index = 1
    var map = HashMap<String, Int>()
    map[user] = 0

    for (i in friends.indices) {
        val (a, b) = friends[i].map { it.toString() }
        if (!map.containsKey(a)) {
            map[a] = index++
        }
        if (!map.containsKey(b)) {
            map[b] = index++
        }
    }
    return map
}

fun addFriends(friends: List<List<String>>, user: String, map: HashMap<String, Int>): Array<MutableList<String>> {
    var graph = Array(map.size){ mutableListOf<String>() }
    for (i in friends.indices) {
        val (a, b) = friends[i].map { it.toString() }
        if (a == user) {
            graph[map[a]!!].add(b)
        }
        else if (b == user) {
            graph[map[b]!!].add(a)
        }
        else {
            graph[map[a]!!].add(b)
            graph[map[b]!!].add(a)
        }
    }
    return graph
}