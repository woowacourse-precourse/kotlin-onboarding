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

fun validatePage(leftNumber: Int, rightNumber: Int) =
    (rightNumber - leftNumber) == 1

fun getBiggerNumber(number1: Int, number2: Int): Int =
    max(number1, number2)

fun compareNumber(number1: Int, number2: Int): Int {
    val diff = number1 - number2
    when {
        diff > 0 -> return 1
        diff < 0 -> return 2
        diff == 0 -> return 0
    }
    return -1
}