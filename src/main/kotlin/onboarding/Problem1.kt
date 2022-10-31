package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (checkPage(pobi, crong)) {
        return -1
    }

    val pobiResult = getResult(pobi)
    val crongResult = getResult(crong)

    return when {
        pobiResult > crongResult -> 1
        pobiResult < crongResult -> 2
        else -> 0
    }
}

fun getResult(person: List<Int>): Int {
    val leftPage = person[0]
    val rightPage = person[1]

    val leftPageSum = 0
    val leftPageMultiply = 1

    val rightPageSum = 0
    val rightPageMultiply = 1

    val leftPageMax = calculatedPage(leftPage, leftPageSum, leftPageMultiply)
    val rightPageMax = calculatedPage(rightPage, rightPageSum, rightPageMultiply)

    return getMaxNum(leftPageMax, rightPageMax)
}

fun calculatedPage(pg: Int, s: Int, mul: Int): Int {
    var page = pg
    var sum = s
    var multiply = mul

    while (page > 0) {
        sum += page % 10
        multiply *= page % 10
        page /= 10
    }
    return getMaxNum(sum, multiply)
}

fun getMaxNum(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}

/** 예외 처리 */
private fun checkPage(pobi: List<Int>, crong: List<Int>): Boolean =
    !(checkExceptionPage(pobi[0], pobi[1]) && checkExceptionPage(crong[0], crong[1]))

private fun checkExceptionPage(leftPage: Int, rightPage: Int): Boolean {
    return (leftPage in 1..400) && (rightPage in 1..400) &&
            (leftPage + 1 == rightPage) &&
            (leftPage % 2 == 1) && (rightPage % 2 == 0)
}

