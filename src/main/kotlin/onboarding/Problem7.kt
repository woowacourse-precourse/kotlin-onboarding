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

    mappingPersonToNum(friends, visitors)

    initCollections()

    setFriendsRelations(friends)

    doAcquaintanceCase(user)

    doVisitorsCase(visitors)

    return getResult()
}

private fun mappingPersonToNum(
    friends: List<List<String>>,
    visitors: List<String>
) {
    map = HashMap()
    var idx = 0

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
}

private fun initCollections() {
    score = IntArray(map.size) { 0 }
    adj = Array(map.size) { ArrayList() }
    visited = BooleanArray(map.size + 1)

    candidate = mutableSetOf()
    bannedList = mutableSetOf()
}

private fun setFriendsRelations(friends: List<List<String>>) {
    friends.forEach {
        adj[map[it.first()]!!].add(map[it.last()]!!)
        adj[map[it.last()]!!].add(map[it.first()]!!)
    }
}

private fun doAcquaintanceCase(user: String) {
    bannedList.add(user)
    visited[map[user]!!] = true
    dfs(map[user]!!, 0)
}

private fun doVisitorsCase(visitors: List<String>) {
    visitors.forEach {
        score[map[it]!!]++
    }
}

private fun getResult(): List<String> {
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
            visited[child] = true
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


