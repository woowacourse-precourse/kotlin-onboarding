package onboarding

import java.lang.Integer.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isWrongPage(pages = pobi) || isWrongPage(pages = crong)) return EXCEPTION_RESULT
    return decideWinner(pobiMaxNum = compareMaxNumber(pobi), crongMaxNum = compareMaxNumber(crong))
}

fun decideWinner(pobiMaxNum: Int, crongMaxNum: Int): Int {
    return when {
        pobiMaxNum > crongMaxNum -> POBI_WIN_RESULT
        crongMaxNum > pobiMaxNum -> CRONG_WIN_RESULT
        else -> TIE_RESULT
    }
}

fun isWrongPage(pages: List<Int>): Boolean {
    val (leftPageNum, rightPageNum) = pages

    return when {
        leftPageNum % 2 != 1 || rightPageNum % 2 != 0 -> true
        rightPageNum - leftPageNum != 1 -> true
        leftPageNum == START_PAGE_NUM || rightPageNum == LAST_PAGE_NUM -> true
        else -> false
    }
}

/**
 * 왼쪽과 오른쪽 페이지를 계산 한 값을 비교해서 가장 큰 값을 반환하는 함수
 */
fun compareMaxNumber(pages: List<Int>): Int {
    val leftMaxNum = calculateMaxNumber(pageNumber = pages[0])
    val rightMaxNum = calculateMaxNumber(pageNumber = pages[1])

    return max(leftMaxNum, rightMaxNum)
}

/**
 * 페이지의 각 자리수를 더하거나 곱해서 비교한 뒤 큰 수를 반환하는 함수
 */
fun calculateMaxNumber(pageNumber: Int): Int {
    var pageNum = pageNumber
    var plusNum = 0
    var multiplyNum = 1

    do {
        val curNum = pageNum % 10

        plusNum += curNum
        multiplyNum *= curNum

        pageNum /= 10
    } while (pageNum > 0)

    return max(plusNum, multiplyNum)
}

const val START_PAGE_NUM = 1
const val LAST_PAGE_NUM = 400
const val POBI_WIN_RESULT = 1
const val CRONG_WIN_RESULT = 2
const val TIE_RESULT = 0
const val EXCEPTION_RESULT = -1