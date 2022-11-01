package onboarding

import kotlin.math.abs

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val draw = 0
    val pobiWin = 1
    val crongWin = 2
    val exception = -1

    if (!isAppropriateList(pobi, crong)) {
        return exception
    }

    return when (compareWhichIsBigNumber(findGreatestPage(pobi), findGreatestPage(crong))) {
        0 -> draw
        1 -> pobiWin
        else -> crongWin
    }
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

fun compareWhichIsBigNumber(pobysGreatestNumber: Int, crongsGreatesNumber: Int): Int {
    return when {
        (pobysGreatestNumber == crongsGreatesNumber) -> 0
        (pobysGreatestNumber > crongsGreatesNumber) -> 1
        else -> 2
    }
}

fun findGreatestPage(list: List<Int>): Int {
    var left = list[0]
    var right = list[1]
    var plusLeft = 0
    var mulLeft = 1
    var plusRight = 0
    var mulRight = 1

    while (left > 0) {
        plusLeft += left % 10
        mulLeft *= left % 10
        left /= 10
    }

    while (right > 0) {
        plusRight += right % 10
        mulRight *= right % 10
        right /= 10
    }

    left = if (plusLeft > mulLeft) plusLeft else mulLeft
    right = if (plusRight > mulRight) plusRight else mulRight
    return if (left > right) left else right
}
