package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

fun getAddedDigitSum(number: Int): Int =
    number.toString()
        .fold(0) { total, digit -> total + Character.getNumericValue(digit) }

fun getMultipliedSum(number: Int): Int =
    number.toString()
        .fold(1) { total, digit -> total * Character.getNumericValue(digit) }

fun validatePage(leftNumber: Int, rightNumber: Int): Boolean {
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

fun calcMaxPages(pages: List<Int>): Int {
    var maxValue = 0
    pages.forEach { pageNumber ->
        maxValue = max(maxValue, getAddedDigitSum(pageNumber))
        maxValue = max(maxValue, getMultipliedSum(pageNumber))
    }
    return maxValue
}

fun compareNumber(number1: Int, number2: Int): Int {
    val diff = number1 - number2
    when {
        diff > 0 -> return 1
        diff < 0 -> return 2
        diff == 0 -> return 0
    }
    return -1
}