package onboarding

import java.lang.Integer.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

}


fun calculateMaxNumber(pages: List<Int>): Int {
    val leftPageNum = pages[0]
    val rightPageNum = pages[1]

    return max(leftPageNum + rightPageNum, leftPageNum * rightPageNum)
}

const val START_PAGE_NUM = 1
const val LAST_PAGE_NUM = 400
const val POBI_WIN_RESULT = 1
const val CRONG_WIN_RESULT = 2
const val TIE_RESULT = 0
const val EXCEPTION_RESULT = -1