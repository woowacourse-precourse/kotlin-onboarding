package onboarding

/**
 * @author onseok
 */

lateinit var visited: BooleanArray
lateinit var adj: Array<ArrayList<Int>>
lateinit var candidate: MutableSet<String>
lateinit var bannedList: MutableSet<String>
lateinit var map: HashMap<String, Int>
lateinit var score: IntArray
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var idx = 0
    map = HashMap()
    friends.forEach {
        if (!map.containsKey(it.first())) {
            map[it.first()] = idx++
        }
        if (!map.containsKey(it.last())) {
            map[it.last()] = idx++
        }
    }
    visitors.forEach {
        if (!map.containsKey(it)) {
            map[it] = idx++
        }
    }
    score = IntArray(map.size) { 0 }
    adj = Array(map.size) { ArrayList() }
    visited = BooleanArray(map.size + 1)
    friends.forEach {
        adj[map[it.first()]!!].add(map[it.last()]!!)
        adj[map[it.last()]!!].add(map[it.first()]!!)
    }

    candidate = mutableSetOf()
    bannedList = mutableSetOf()
    bannedList.add(user)
    dfs(map[user]!!, 0)

    visitors.forEach {
        score[map[it]!!]++
    }
    val scoreDetail = ArrayList<Pair<String, Int>>()
    score.forEachIndexed { index, i ->
        scoreDetail.add(Pair(find(index), i))
    }

    val res = scoreDetail.filter { !bannedList.contains(it.first) }
    val result = mutableListOf<String>()
    res.forEach {
        result.add(it.first)
    }
    return result.toList()
}

private fun dfs(num: Int, depth: Int) {
    visited[num] = true
    if (depth == 1) {
        bannedList.add(find(num))
    }
    if (depth == 2) {
        score[num] += 10
        candidate.add(find(num))
        return
    }
    for (child in adj[num]) {
        if (!visited[child]) {
            dfs(child, depth + 1)
            visited[child] = false
        }
    }
}

fun find(num: Int): String {
    for (key in map.keys) {
        if (map[key] == num) {
            return key
        }
    }
    return ""
}


