package onboarding

const val POBI_WIN = 1
const val CRONG_WIN = 2
const val DRAW = 0
const val INPUT_EXCEPTION = -1

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isInputException(pobi, crong)) return INPUT_EXCEPTION

    val pobiPoint = calculateMaxPoint(pobi)
    val crongPoint = calculateMaxPoint(crong)

    return when {
        pobiPoint > crongPoint -> POBI_WIN
        pobiPoint < crongPoint -> CRONG_WIN
        pobiPoint == crongPoint -> DRAW
        else -> throw IllegalStateException("의도하지 않은 코드")
    }
}

private fun isInputException(pobi: List<Int>, crong: List<Int>): Boolean {
    val tempList = listOf(pobi, crong)

    tempList.forEach {
        if (isNotInPageRange(it)) return true
        if (isNotContinuedNumber(it)) return true
        if (isNotLeftPageOddNumber(it)) return true
        if (isStartOrEndPage(it)) return true
    }

    return false
}

private fun isNotInPageRange(pages: List<Int>): Boolean {
    for (i: Int in pages) if (i !in 1..400) return true
    return false
}

private fun isNotContinuedNumber(pages: List<Int>): Boolean = pages[1] - pages[0] != 1

private fun isNotLeftPageOddNumber(pages: List<Int>): Boolean = pages[0] % 2 != 1

private fun isStartOrEndPage(pages: List<Int>): Boolean = pages[0] == 1 || pages[1] == 400

private fun calculateMaxPoint(pages: List<Int>): Int = maxOf(
    calculatePlusPoint(pages[0]),
    calculatePlusPoint(pages[1]),
    calculateMultiplyPoint(pages[0]),
    calculateMultiplyPoint(pages[1])
)

private fun calculatePlusPoint(page: Int): Int {
    var maxPoint = 0

    val tempPage = page.toString()

    for (i: Char in tempPage) {
        maxPoint += Character.getNumericValue(i)
    }

    return maxPoint
}

private fun calculateMultiplyPoint(page: Int): Int {
    var maxPoint = 1

    val tempPage = page.toString()

    for (i: Char in tempPage) {
        maxPoint *= Character.getNumericValue(i)
    }

    return maxPoint
}
