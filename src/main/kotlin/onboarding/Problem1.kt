package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    return try {

        if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) throw java.lang.Exception("")
        if (pobi[0] % 2 == 0 || crong[0] % 2 == 0) throw java.lang.Exception("")

        val pobiScore = pobi.maxOf { findMaxValueFromPage(it) }
        val crongScore = crong.maxOf { findMaxValueFromPage(it) }
        when {
            pobiScore < crongScore -> 2
            pobiScore == crongScore -> 0
            else -> 1
        }
    } catch (e: Exception) {
        -1
    }
}
fun findMaxValueFromPage(page: Int): Int {
    val intList = page.toString().toList().map { it.toString().toInt() }

    val added = intList.sum()
    val multiplied = intList.reduce { a, b -> a * b }

    return maxOf(added, multiplied)
}