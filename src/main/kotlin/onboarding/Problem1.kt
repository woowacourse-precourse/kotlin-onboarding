package onboarding

import kotlin.math.abs

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(isErrorExist(pobi, crong))
        return -1

    return -1
}

fun isInputError(list: List<Int>): Boolean {
    return list[0] % 2 == 0 || list[1] % 2 != 0 || abs(list[0] - list[1]) != 1
}

fun isErrorExist(pobi: List<Int>, crong: List<Int>): Boolean {
    if (isInputError(pobi) || isInputError(crong)) {
        return true
    }

    return false
}

fun getAdd(number: Int): Int {
    var result = 0

    for (num in number.toString()) {
        result += Character.getNumericValue(num)
    }
    return result
}

fun getMul(number: Int): Int {
    var result = 1
    for (num in number.toString()) {
        result *= Character.getNumericValue(num)
    }
    return result
}