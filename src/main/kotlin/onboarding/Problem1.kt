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
    // 2개의 페이지를 가져야 한다.
    if (pages.size != 2) return false

    // 2개의 페이지는 모두 2 ~ 399 사이의 자연수이다.
    if (pages.any { it !in 2..399 }) return false

    // 2개의 페이지는 [홀수, 짝수] 이며 짝수는 홀수 + 1 이어야 한다.
    if (pages[0] % 2 == 0 ||
        pages[0] + 1 != pages[1]) return false

    return true
}

private fun score(pages: List<Int>): Int {
    val leftDigits = getDigits(pages[0])
    val rightDigits = getDigits(pages[1])

    val leftSum = leftDigits.sum()
    val rightSum = rightDigits.sum()

    val leftMul = leftDigits.fold(1) { acc, num -> acc * num }
    val rightMul = rightDigits.fold(1) { acc, num -> acc * num }

    return maxOf(leftSum, leftMul, rightSum, rightMul)
}

private fun getDigits(num: Int): List<Int> {
    val digits = mutableListOf<Int>()

    var digit = num
    while (digit > 0) {
        digits.add(digit % 10)
        digit /= 10
    }

    return digits
}


