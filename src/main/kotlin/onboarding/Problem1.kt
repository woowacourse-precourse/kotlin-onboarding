package onboarding

private const val ERROR = -1
private const val POBI_WIN = 1
private const val CRONG_WIN = 2
private const val DRAW = 0

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isException(pobi)) return ERROR
    if (!isException(crong)) return ERROR
}

private fun isException(pages: List<Int>): Boolean {
    return (isContinuous(pages) and isInRange(pages))
}

private fun isContinuous(pages: List<Int>): Boolean {
    return (pages[1] - pages[0] == 1)
}

private fun isInRange(pages: List<Int>): Boolean {
    return (pages[0] in 3..398) and (pages[1] in 3..398)
}

