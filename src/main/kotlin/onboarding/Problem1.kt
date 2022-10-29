package onboarding

import kotlin.math.max


fun getScroe(pageList: List<Int>): Int {
    val leftPage = pageList[0]
    val rightPage = pageList[1]

    val biggestNumInLeftPage = max(addDigit(leftPage), multiplyDigit(leftPage))
    val biggestNumInRightPage = max(addDigit(rightPage), multiplyDigit(rightPage))

    return max(biggestNumInLeftPage, biggestNumInRightPage)
}

fun addDigit(num: Int): Int {
    var tempNum = num
    var result = 0
    while (tempNum > 0) {
        result += (tempNum % 10)
        tempNum /= 10
    }

    return result
}


fun multiplyDigit(num: Int): Int {
    var tempNum = num
    var result = 1
    while (tempNum > 0) {
        result *= (tempNum % 10)
        tempNum /= 10
    }

    return result
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiScore = getScroe(pobi)
    val crongScore = getScroe(crong)

    return 0
}