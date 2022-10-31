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

    mappingPersonToNum(user, friends, visitors)

    initCollections()

    setFriendsRelations(friends)

    doAcquaintanceCase(user)

    doVisitorsCase(visitors)

    return getResult()
}

private fun mappingPersonToNum(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
) {
    map = HashMap()
    var idx = 0

    if (!map.containsKey(user)) {
        map[user] = idx++
    }

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
    println(scoreDetail)
    // 아이디와 점수가 함께 있는 리스트
    val resultWithId = scoreDetail
        .sortedBy { it.first } // 이름순 정렬
        .filter { !bannedList.contains(it.first) } // 친구 혹은 user 제외
        .filter { it.second != 0 } // 점수가 0이 아닌 경우는 제외
        .sortedByDescending { it.second } // 점수 높은 순으로 정렬
        .take(5) // 상위 5개만 뽑기
    val result = mutableListOf<String>() // 아이디만 있는 리스트
    resultWithId.forEach {
        result.add(it.first)
    }
    return result.toList()
}

private fun dfs(num: Int, depth: Int) {
    if (depth == 1) { // depth가 1인 경우는 친구인 경우이므로 제외시키기
        bannedList.add(find(num))
    }
    if (depth == 2) { // depth가 2인 경우는 함꼐아는 친구이고 그 이상은 함께아는 친구가 아니므로 여기서 return
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


