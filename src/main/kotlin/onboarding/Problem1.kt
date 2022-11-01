package onboarding

import kotlin.math.max

fun isException(pages: List<Int>): Boolean {
    if (pages[0] + 1 != pages[1]) return true
    if (pages[0] < 1 || pages[1] < 1 || pages[0] > 400 || pages[1] > 400) return true
    return false
}

fun findMaxValue(num: Int): Int {
    var plusRes = 0
    var multiRes = 1
    var n = num
    while (n > 0) {
        val tmp = n % 10
        plusRes += tmp
        multiRes *= tmp
        n /= 10
    }
    return max(plusRes, multiRes)
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isException(pobi) || isException(crong)) return -1
    val pobiScore = max(findMaxValue(pobi[0]), findMaxValue(pobi[1]))
    val crongScore = max(findMaxValue(crong[0]), findMaxValue(crong[1]))
    return when {
        pobiScore == crongScore -> 0
        pobiScore > crongScore -> 1
        else -> 2
    }
}
