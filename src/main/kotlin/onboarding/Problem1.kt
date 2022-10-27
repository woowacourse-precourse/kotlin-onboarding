package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!checkValidation(pobi, crong))
        return -1

    val pobiPoint = pobi.getPoints()
    val crongPoint = crong.getPoints()

    return if (pobiPoint > crongPoint) 1
    else if (pobiPoint < crongPoint) 2
    else 0
}

private fun checkValidation(vararg pages: List<Int>): Boolean {
    return pages.all { page ->
        (page.size == 2) &&
                (page[0] in 1..400) &&
                (page[1] in 1..400) &&
                (page[0] % 2 == 1) &&
                (page[1] % 2 == 0) &&
                (page[1] - page[0] == 1)
    }
}

private fun List<Int>.getPoints(): Int {
    return maxOf {
        val page = it.toString()

        max(
            page.fold(0) { acc, n -> acc + n.digitToInt() },
            page.fold(1) { acc, n -> acc * n.digitToInt() },
        )
    }
}