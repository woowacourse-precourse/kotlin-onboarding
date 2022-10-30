package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(!checkNoException(pobi, crong)) {
        return -1
    }
    return 0
}

private fun checkNoException(pobi: List<Int>, crong: List<Int>): Boolean {
    return (checkPageRange(pobi[0], pobi[1])
            || checkPageRange(crong[0], crong[1])
            || checkValidPage(pobi[0], pobi[1])
            || checkValidPage(crong[0], crong[1])
            || checkPairPage(pobi[0], pobi[1])
            || checkPairPage(crong[0], crong[1]))
}

private fun checkPageRange(leftPage: Int, rightPage: Int) = (leftPage > 1 && rightPage < 400)

private fun checkValidPage(leftPage: Int, rightPage: Int) = (rightPage - leftPage == 1)

private fun checkPairPage(leftPage: Int, rightPage: Int) = (leftPage%2 == 1 && rightPage%2 == 0)

private fun calculatePoint(page: List<Int>): Int {
    var calculatedNumList: MutableList<Int> = mutableListOf()

    calculatedNumList.add(calculateMaxNum(page[0]))
    calculatedNumList.add(calculateMaxNum(page[1]))
    calculatedNumList.sortedDescending()

    return calculatedNumList[0]
}

private fun calculateMaxNum(page: Int): Int{
    var page = page
    var plusPage = 0
    var multiplyPage= 1
    var maxNum = 0
    while(page > 0) {
        plusPage += page%10
        multiplyPage *= page%10
        page /= 10
    }

    maxNum = if(plusPage < multiplyPage) {
        multiplyPage
    } else {
        plusPage
    }

    return maxNum
}