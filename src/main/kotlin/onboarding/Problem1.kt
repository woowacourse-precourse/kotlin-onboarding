package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isPageValid(pobi) || !isPageValid(crong)) {
        return -1
    }
}

fun isPageValid(pageNumbers: List<Int>): Boolean {
    if(pageNumbers[0] + 1 != pageNumbers[1]) {
        return false
    }

    if(pageNumbers[0] % 2 != 1 || pageNumbers[1] % 2 != 0) {
        return false
    }

    for(page in pageNumbers) {
        if(page == 1 || page == 4) {
            return false
        }
    }

    return true
}

fun getSumScore(number: Int): Int {
    val str = number.toString()
    var result = 0

    for (c in str) {
        result += c - '0'
    }

    return result
}

fun getMulScore(number: Int): Int {
    val str = number.toString()
    var result = 1

    for (c in str) {
        result *= c - '0'
    }

    return result
}

fun getScoreByPage(pageNumbers: List<Int>): Int {
    var result = 0

    for (i in 0..1) {
        result = max(result, getMulScore(pageNumbers[i]))
        result = max(result, getSumScore(pageNumbers[i]))
    }

    return result
}