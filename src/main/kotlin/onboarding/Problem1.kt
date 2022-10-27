package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!checkValidation(pobi, crong))
        return -1

    return compare(getScore(pobi), getScore(crong))
}

private fun checkValidation(vararg pages: List<Int>): Boolean {
    return pages.all { page ->
        (page.size == 2)
                && (page[0] in 1..400)
                && (page[1] in 1..400)
                && (page[0] % 2 == 1)
                && (page[1] % 2 == 0)
                && (page[1] - page[0] == 1)
    }
}

private fun getScore(pages: List<Int>): Int {
    return pages.maxOf { page ->

        max(page.toString().fold(0) { acc, n -> acc + n.digitToInt() },
            page.toString().fold(1) { acc, n -> acc * n.digitToInt() })
    }
}

private fun compare(score1: Int, score2: Int): Int {
    return if (score1 > score2) 1 else if (score1 < score2) 2 else 0
}