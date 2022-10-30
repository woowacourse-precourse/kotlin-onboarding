package onboarding

private const val ERROR         = -1
private const val DRAW          = 0
private const val POBI_WIN      = 1
private const val CRONG_WIN     = 2

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if ((validate(pobi) && validate(crong)) == false) {
        return ERROR
    }

    val pobiScore = score(pobi)
    val crongScore = score(crong)
    val diff = pobiScore - crongScore

    val result = if (diff > 0) {
        POBI_WIN
    } else if (diff < 0) {
        CRONG_WIN
    } else {
        DRAW
    }

    return result
}

private fun validate(pages: List<Int>): Boolean {
    TODO("유효성 검사")
}

private fun score(pages: List<Int>): Int {
    TODO("점수계산")
}


