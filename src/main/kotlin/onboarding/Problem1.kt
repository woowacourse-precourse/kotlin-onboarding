package onboarding

import java.lang.Integer.max

fun main(args: Array<String>){
    val pobi = listOf<Int>(97, 98)
    val crong = listOf<Int>(197, 198)

    println(solution1(pobi, crong))
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isWrongPage(pobi) || isWrongPage(crong))
        return EXCEPTION_RESULT

    val pobiMaxNum = calculateMaxNumber(pobi)
    val crongMaxNum = calculateMaxNumber(crong)

    if (pobiMaxNum > crongMaxNum)
        return POBI_WIN_RESULT

    if (crongMaxNum > pobiMaxNum)
        return CRONG_WIN_RESULT

    return TIE_RESULT
}

fun isWrongPage(pages: List<Int>): Boolean {
    val leftPageNum = pages[0]
    val rightPageNum = pages[1]

    if (rightPageNum - leftPageNum != 1 || leftPageNum == START_PAGE_NUM || rightPageNum == LAST_PAGE_NUM)
        return true
    return false
}

fun compareMaxNumber(pages: List<Int>): Int {
    val leftMaxNum = calculateMaxNumber(pageNumber = pages[0])
    val rightMaxNum = calculateMaxNumber(pageNumber = pages[1])

    return max(leftMaxNum, rightMaxNum)
}

fun calculateMaxNumber(pageNumber: Int): Int {
    var pageNum = pageNumber
    var plusNum = 0
    var multiplyNum = 1

    while(pageNum > 0) {
        val curNum = pageNum % 10

        plusNum += curNum
        multiplyNum *= curNum

        pageNum /= 10
    }
    return max(plusNum, multiplyNum)
}

const val START_PAGE_NUM = 1
const val LAST_PAGE_NUM = 400
const val POBI_WIN_RESULT = 1
const val CRONG_WIN_RESULT = 2
const val TIE_RESULT = 0
const val EXCEPTION_RESULT = -1