package onboarding

const val POBI_WIN = 1
const val CRONG_WIN = 2
const val DRAW = 0
const val INPUT_EXCEPTION = -1

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if(isInputException(pobi, crong)) return INPUT_EXCEPTION

}

private fun isInputException(pobi: List<Int>, crong: List<Int>): Boolean {
    val tempList = listOf<List<Int>>(pobi, crong)

    tempList.forEach {
        if (isPageRange(it)) return true
        if (isContinuedNumber(it)) return true
        if (isLeftPageOddNumber(it)) return true
        if (isValidPage(it)) return true
    }

    return false
}

private fun isPageRange(pages: List<Int>): Boolean {
    for (i: Int in pages) if (i !in 1..400) return true
    return false
}

private fun isContinuedNumber(pages: List<Int>): Boolean = pages[0] - pages[1] != 1

private fun isLeftPageOddNumber(pages: List<Int>): Boolean = pages[0] % 2 != 1

private fun isValidPage(pages: List<Int>): Boolean = pages[0] == 1 || pages[1] == 400
