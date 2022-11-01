package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val relation = mutableMapOf<String, MutableSet<String>>()
    val snsScore = mutableMapOf<String, Int>()
    val ans = listOf<String>()

    for (data in friends) {
        if (relation[data[0]] == null) {
            snsScore[data[0]] = 0
            relation[data[0]] = mutableSetOf()
        } else {
            relation[data[0]]?.add(data[1])
        }
        if (relation[data[1]] == null) {
            relation[data[1]] = mutableSetOf()
            snsScore[data[1]] = 0
        } else {
            relation[data[1]]?.add(data[0])

        }
        relation[data[1]]?.add(data[0])
    }

    relation[user]?.forEach {
        relation[it]?.forEach { friend ->
            snsScore[friend] = snsScore[friend]!! + 10
        }
    }

    

    return ans
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
    val result = listOf("andole", "jun", "bedi")
    print(solution7(user, friends, visitors).equals(result))
}