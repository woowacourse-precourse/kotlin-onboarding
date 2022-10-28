package onboarding

import kotlin.math.max

/*------Custom Variables------*/
val FIRST_PAGE = 0
val LAST_PAGE = 400
/*----------------------------*/

/*------Custom Functions------*/
/**
 * Returns whether the [page] is valid.
 */
fun isValidPages(page: List<Int>) : Boolean {
    if(page.size != 2) return false
    if(page[0] - page[1] != 1) return false
    if(page[0] % 2 == 0) return false
    if(page[0] == FIRST_PAGE || page[1] == LAST_PAGE) return false
    return true
}

/**
 * Returns a biggest Number which can be made from [pageNumber]
 */
fun makeBigNumber(pageNumber: Int) : Int {
    var pageSum: Int = 0
    var pageMultiply: Int = 1
    var remainder: Int = pageNumber
    while(remainder != 0) {
        pageSum += pageNumber % 10
        pageMultiply *= pageNumber % 10
        remainder /= 10
    }
    return max(pageSum, pageMultiply)
}

/*----------------------------*/


fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}
