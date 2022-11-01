package onboarding

import kotlin.math.abs

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val exception = -1

    if (!isAppropriateList(pobi, crong)) {
        return exception
    }
    return -1
}

fun isAppropriateList(pobi: List<Int>, crong: List<Int>): Boolean {
    return when {
        !(pobi[0] in 1..399 && pobi[1] in 1..399) -> false
        !(crong[0] in 1..399 && crong[1] in 1..399) -> false
        abs(pobi[0] - pobi[1]) > 1 || abs(crong[0] - crong[1]) > 1 -> false
        pobi[0] > pobi[1] || crong[0] > crong[1] -> false
        else -> true
    }
}
