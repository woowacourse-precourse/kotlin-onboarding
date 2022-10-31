package onboarding

import kotlin.math.max

fun isValidInput(leftPage: Int, rightPage: Int): Boolean {
    return when {
        leftPage == 1 || rightPage == 400 -> false
        rightPage - leftPage != 1 -> false
        leftPage % 2 != 1 || rightPage % 2 != 0 -> false
        else -> true
    }
}

fun getScore(number: Int): Int {
    val sumResult = number.toString().map { it.digitToInt() }
        .reduce { acc, i -> acc + i }

    val multiResult = number.toString().map { it.digitToInt() }
        .reduce { acc, i -> acc * i }

    return max(sumResult, multiResult)
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isValidInput(pobi[0], pobi[1]) || !isValidInput(crong[0], crong[1]))
        return -1

    val pobiScore = max(getScore(pobi[0]), getScore(pobi[1]))
    val crongScore = max(getScore(crong[0]), getScore(crong[1]))

    return when {
        pobiScore > crongScore -> 1
        pobiScore < crongScore -> 2
        else -> 0
    }
}