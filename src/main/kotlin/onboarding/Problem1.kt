package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (validateTwoPages(pobi[0], pobi[1]) && validateTwoPages(crong[0], crong[1])) {
        val pobiMaxNumber = calcMaxPages(pobi)
        val crongMaxNumber = calcMaxPages(crong)
        return compareNumber(pobiMaxNumber, crongMaxNumber)
    }
    return -1
}

private fun validateTwoPages(leftNumber: Int, rightNumber: Int): Boolean {
    val zero = 0; val one = 1; val two = 2
    val minimumPage = 1; val maximumPage = 400
    when {
        leftNumber !in (minimumPage..maximumPage) -> return false
        rightNumber !in (minimumPage..maximumPage) -> return false
        leftNumber % two == zero -> return false
        rightNumber % two == one -> return false
    }
    return (leftNumber + one) == rightNumber
}

private fun calcMaxPages(pages: List<Int>): Int {
    var maxValue = 0
    pages.forEach { pageNumber ->
        maxValue = max(maxValue, getAddedDigitSum(pageNumber))
        maxValue = max(maxValue, getMultipliedSum(pageNumber))
    }
    return maxValue
}

private fun getAddedDigitSum(number: Int): Int =
    number.toString()
        .fold(0) { total, digit -> total + Character.getNumericValue(digit) }

private fun getMultipliedSum(number: Int): Int =
    number.toString()
        .fold(1) { total, digit -> total * Character.getNumericValue(digit) }

private fun compareNumber(number1: Int, number2: Int): Int {
    val diff = number1 - number2
    val exceptedNumber = -1
    val drawNumber = 0
    val pobiWinningNumber = 1
    val crongWinningNumber = 2
    when {
        diff > 0 -> return pobiWinningNumber
        diff < 0 -> return crongWinningNumber
        diff == 0 -> return drawNumber
    }
    return exceptedNumber
}