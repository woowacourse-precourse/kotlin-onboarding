package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val scoreMap = calculateVisitor(visitors)
    val friendMap = calFriendMap(friends)
    val userFriendList = friendMap[user]


}

fun calculateVisitor(visitors: List<String>) : MutableMap<String, Int> {
    val resultMap = mutableMapOf<String, Int>()
    for (v in visitors) {
        resultMap[v] = resultMap.getOrDefault(v, 0) + 1
    }

    return resultMap
}


fun calFriendMap(friends: List<List<String>>) : MutableMap<String, List<String>> {
    val resultMap = mutableMapOf<String, List<String>>()

    for (f in friends) {
        val a = f[0]
        val b = f[1]
        resultMap[a] = resultMap.getOrDefault(a, listOf()).plus(b)
        resultMap[b] = resultMap.getOrDefault(b, listOf()).plus(a)
    }
    return resultMap
}