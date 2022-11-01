package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val scoreMap = calculateVisitor(visitors)

}

fun calculateVisitor(visitors: List<String>) : MutableMap<String, Int> {
    val resultMap = mutableMapOf<String, Int>()
    for (v in visitors) {
        resultMap[v] = resultMap.getOrDefault(v, 0) + 1
    }

    return resultMap
}
