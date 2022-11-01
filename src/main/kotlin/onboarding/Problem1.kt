package onboarding

import kotlin.math.max

/*------Custom Variables------*/
const val FIRST_PAGE = 0
const val LAST_PAGE = 400
/*----------------------------*/

/*------Custom Functions------*/
/**
 * Returns whether the [page] is valid.
 */
fun isValidPages(page: List<Int>) : Boolean {
    if(page.size != 2) return false
    if(page[1] - page[0] != 1) return false
    if(page[0] % 2 == 0) return false
    if(page[0] == FIRST_PAGE || page[1] == LAST_PAGE) return false
    return true
}

/**
 * Returns the biggest Number which can be made from [pageNumber]
 */
fun makeBigNumber(pageNumber: Int) : Int {
    var pageSum: Int = 0
    var pageMultiply: Int = 1
    var remainder: Int = pageNumber
    while(remainder != 0) {
        pageSum += remainder % 10
        pageMultiply *= remainder % 10
        remainder /= 10
    }
    return max(pageSum, pageMultiply)
}

/**
 * Returns the score which can be obtained by [page]
 */
fun calculateScore(page: List<Int>) : Int {
    return max(makeBigNumber(page[0]), makeBigNumber(page[1]))
}

/*----------------------------*/


fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!isValidPages(pobi) || !isValidPages(crong)) return -1

    val pobiScore: Int = calculateScore(pobi)
    val crongScore: Int = calculateScore(crong)
    if(pobiScore > crongScore) return 1
    if(pobiScore < crongScore) return 2
    return 0
}
