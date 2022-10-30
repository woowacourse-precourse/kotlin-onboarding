package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var map = HashMap<String, Int>()
    map = setUniqueNumber(friends)

    TODO("프로그램 구현")
}

fun setUniqueNumber(friends: List<List<String>>): HashMap<String, Int> {
    var index = 0
    var map = HashMap<String, Int>()

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