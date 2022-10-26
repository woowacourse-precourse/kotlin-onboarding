package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (hasExceptions(pobi, crong)) {
        return -1
    }

    val pobiScore = calculateMaxPoints(pobi)
    val crongScore = calculateMaxPoints(crong)

    return when {
        pobiScore > crongScore -> 1
        pobiScore == crongScore -> 0
        else -> 2
    }
}

private fun hasExceptions(pobi: List<Int>, crong: List<Int>): Boolean {
    return !(checkValidateRange(pobi[0]) &&
            checkValidateRange(pobi[1]) &&
            checkValidateRange(crong[0]) &&
            checkValidateRange(crong[1]) &&
            checkValidatePage(pobi[0], pobi[1]) &&
            checkValidatePage(crong[0], crong[1]))
}

private fun checkValidateRange(page: Int): Boolean =
    page in 1..400

private fun checkValidatePage(leftPage: Int, rightPage: Int): Boolean =
    leftPage + 1 == rightPage && leftPage % 2 == 1 && rightPage % 2 == 0

private fun calculateMaxPoints(list: List<Int>): Int {
    var left = list[0]
    var right = list[1]

    val resultList: MutableList<Int> = mutableListOf<Int>()

    var leftPlusResult = 0
    var leftMultiplyResult = 1
    while (left != 0) {
        leftPlusResult += left % 10
        leftMultiplyResult *= left % 10
        left /= 10
    }
    resultList.add(leftPlusResult)
    resultList.add(leftMultiplyResult)

    var rightPlusResult = 0
    var rightMultiplyResult = 1
    while (right != 0) {
        rightPlusResult += right % 10
        rightMultiplyResult *= right % 10
        right /= 10
    }
    resultList.add(rightPlusResult)
    resultList.add(rightMultiplyResult)

    resultList.sortDescending()
    return resultList[0]
}