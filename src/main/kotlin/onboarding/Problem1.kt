package onboarding

const val FIRST_PAGE = 0
const val SECOND_PAGE = 1
const val POBI_WIN = 1
const val CRONG_WIN = 2
const val DRAW = 0
const val EXCEPTION = -1

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isException(pobi, crong)) return EXCEPTION

    val pobiScore = calculateScore(pobi)
    val crongScore = calculateScore(crong)

    return when {
        pobiScore > crongScore -> POBI_WIN
        pobiScore == crongScore -> DRAW
        pobiScore < crongScore -> CRONG_WIN
        else -> EXCEPTION
    }
}

private fun isException(pobi: List<Int>, crong: List<Int>): Boolean {
    listOf(pobi, crong).forEach { list ->
        if (isListSizeException(list)) return true
        if (isPageRangeException(list)) return true
        if (isContinuedPageException(list)) return true
    }

    return false
}

private fun isListSizeException(list: List<Int>): Boolean {
    if (list.size != 2) return true
    return false
}

private fun isPageRangeException(list: List<Int>): Boolean {
    if (list[FIRST_PAGE] <= 1 || list[SECOND_PAGE] >= 400) return true
    return false
}

private fun isContinuedPageException(list: List<Int>): Boolean {
    if (list[SECOND_PAGE] - list[FIRST_PAGE] != 1) return true
    return false
}

fun calculateSumOfPageNumber(num: Int): Int {
    var input = num
    var result = 0
    while (input != 0) {
        result += input % 10
        input /= 10
    }
    return result
}

fun calculateMultiplyOfPageNumber(num: Int): Int {
    var input = num
    var result = 1
    while (input != 0) {
        result *= input % 10
        input /= 10
    }
    return result
}

fun calculateScore(list: List<Int>): Int {
    return maxOf(
        calculateSumOfPageNumber(list[FIRST_PAGE]),
        calculateMultiplyOfPageNumber(list[FIRST_PAGE]),
        calculateSumOfPageNumber(list[SECOND_PAGE]),
        calculateMultiplyOfPageNumber(list[SECOND_PAGE])
    )
}
