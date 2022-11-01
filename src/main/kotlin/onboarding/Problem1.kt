package onboarding

import kotlin.math.max

private const val ERROR = -1
private const val POBI_WIN = 1
private const val CRONG_WIN = 2
private const val DRAW = 0

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isException(pobi)) return ERROR
    if (!isException(crong)) return ERROR

    val pobiMax = calculatePageMax(pobi)
    val crongMax = calculatePageMax(crong)

    return if (pobiMax > crongMax) POBI_WIN
    else if (crongMax > pobiMax) CRONG_WIN
    else DRAW
}

private fun isException(pages: List<Int>): Boolean {
    return (isContinuous(pages) and isInRange(pages) and checkOddEven(pages))
}

private fun isContinuous(pages: List<Int>): Boolean {
    return (pages[1] - pages[0] == 1)
}

private fun isInRange(pages: List<Int>): Boolean {
    return (pages[0] in 3..398) and (pages[1] in 3..398)
}

private fun checkOddEven(pages: List<Int>): Boolean {
    return (pages[0] % 2 != 0) and (pages[1] % 2 == 0)
}

private fun calculatePageMax(pages: List<Int>): Int {
    val leftPage = max(plusDigit(pages[0]), multipleDigit(pages[0]))
    val rightPage = max(plusDigit(pages[1]), multipleDigit(pages[1]))
    return max(leftPage, rightPage)
}

private fun plusDigit(x: Int): Int {
    var input = x
    var result = 0
    while (input != 0) {
        result += input % 10
        input /= 10
    }
    return result
}

private fun multipleDigit(x: Int): Int {
    var input = x
    var result = 1
    while (input != 0) {
        result *= input % 10
        input /= 10
    }
    return result
}
