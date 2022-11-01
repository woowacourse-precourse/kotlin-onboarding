package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (checkForExceptions(pobi) || checkForExceptions(crong))
        return -1

    val largestNumOfPobi = pobi.getMaxNumber()
    val largestNumOfCrong = crong.getMaxNumber()

    return when {
        largestNumOfPobi > largestNumOfCrong -> 1
        largestNumOfPobi < largestNumOfCrong -> 2
        else -> 0
    }
}
fun List<Int>.getMaxNumber(): Int {
    return maxOf {
        val page = it.toString()

        max(
            page.fold(0) { total, num ->
                total + num.digitToInt()
            },

            page.fold(1) { total, num ->
                total * num.digitToInt()
            },
        )
    }
}

fun checkForExceptions(page: List<Int>) : Boolean {
    return when (page[1] - page[0]) {
        1 -> false
        else -> true
    }
}