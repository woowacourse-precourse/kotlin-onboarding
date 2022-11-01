package onboarding

fun getUserFriends(
    user: String,
    friends: List<List<String>>)
: List<String> {
    return friends.filter{ it.contains(user)
    }.mapIndexed { _, it -> it[it.indexOf(user) xor 1] }.toList()
}
fun getVisitorsScore(
    visitors: List<String>,
    resultMap: HashMap<String, Int>) {
    for (visitor in visitors) {
        resultMap[visitor] = resultMap[visitor]?.plus(1) ?: 0
    }
}
fun getCloseness(
    userFriends: List<String>,
    friends: List<List<String>>,
    resultMap: HashMap<String, Int>) {
    for (closeness in userFriends.flatMap{ userFriend->getUserFriends(userFriend, friends)}) {
        resultMap[closeness] = resultMap[closeness]?.plus(10) ?: 0
    }
}
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val resultMap =hashMapOf<String, Int>()
    val userFriends =getUserFriends(user, friends)

    getCloseness(userFriends, friends, resultMap)
    getVisitorsScore(visitors, resultMap)

    return resultMap.toList()
        .sortedByDescending{mapEntry->mapEntry.second}
        .filterIndexed { _, mapEntry ->
        if (!userFriends.contains(mapEntry.first) && mapEntry.first != user) {
            true
        } else {
            false
        }
    }.mapIndexed { _, (first) -> first
    }.take(5)
}

fun main() {
    val user = "mrko"
    val friends = listOf(
        listOf("donut", "andole"),
        listOf("donut", "jun"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko")
    )
    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")


    print(solution7(user,friends,visitors))
}