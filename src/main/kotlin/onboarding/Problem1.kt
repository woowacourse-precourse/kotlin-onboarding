package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (checkExceptions(pobi, crong)) {
        return -1
    }

    val pobiScore = calculateMaxPoint(pobi[0], pobi[1])
    val crongScore = calculateMaxPoint(crong[0], crong[1])

    return when {
        pobiScore == crongScore -> 0
        pobiScore > crongScore -> 1
        pobiScore < crongScore -> 2
        else -> -1
    }
}

private fun checkExceptions(pobi: List<Int>, crong: List<Int>): Boolean {
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


private fun calculatePagePoint(page: Int): Int {
    var additionResult = 0
    var multiplicationResult = 1

    var remainDigits = page
    while (remainDigits != 0) {
        additionResult += remainDigits % 10
        multiplicationResult *= remainDigits % 10
        remainDigits /= 10
    }

    return if (additionResult >= multiplicationResult) {
        additionResult
    } else {
        multiplicationResult
    }
}

private fun calculateMaxPoint(leftPage: Int, rightPage: Int): Int {
    val leftPageScore = calculatePagePoint(leftPage)
    val rightPageScore = calculatePagePoint(rightPage)
    return if (leftPageScore >= rightPageScore) {
        leftPageScore
    } else {
        rightPageScore
    }
}