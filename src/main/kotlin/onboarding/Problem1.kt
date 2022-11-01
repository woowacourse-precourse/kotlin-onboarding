package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    try {
        val pobiScore = getScore(pobi)
        val crongScore = getScore(crong)

        if (pobiScore > crongScore) {
            return 1
        }
        if (pobiScore == crongScore) {
            return 0
        }
        return 2
    } catch (error: IllegalArgumentException) {
        return -1
    }
}

private fun getScore(pageList: List<Int>): Int {
    val leftPage = pageList[0]
    val rightPage = pageList[1]

    if (leftPage < 0 || leftPage > 400 || rightPage < 0 || rightPage > 400) {
        throw IllegalArgumentException("책 페이지를 넘어가는 값이 입력되었습니다.")
    }
    if (rightPage - leftPage != 1) {
        throw IllegalArgumentException("왼쪽 페이지와 오른쪽 페이지 값은 연속된 값이여야 합니다.")
    }
    if (rightPage % 2 == 1) {
        throw IllegalArgumentException("오른쪽 페이지의 값은 짝수여야 합니다.")
    }
    if (leftPage % 2 == 0) {
        throw IllegalArgumentException("왼쪽 페이지의 값은 홀수여야 합니다.")
    }

    val biggestNumInLeftPage = max(addDigit(leftPage), multiplyDigit(leftPage))
    val biggestNumInRightPage = max(addDigit(rightPage), multiplyDigit(rightPage))

    return max(biggestNumInLeftPage, biggestNumInRightPage)
}

private fun addDigit(num: Int): Int {
    var tempNum = num
    var result = 0

    while (tempNum > 0) {
        result += (tempNum % 10)
        tempNum /= 10
    }

    return result
}


private fun multiplyDigit(num: Int): Int {
    var tempNum = num
    var result = 1

    while (tempNum > 0) {
        result *= (tempNum % 10)
        tempNum /= 10
    }

    return result
}
