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

fun isAppropriateList(pobi: List<Int>, crong: List<Int>) = when {
    !(pobi[0] in 1..399 && pobi[1] in 1..399) -> false
    !(crong[0] in 1..399 && crong[1] in 1..399) -> false
    abs(pobi[0] - pobi[1]) > 1 || abs(crong[0] - crong[1]) > 1 -> false
    pobi[0] > pobi[1] || crong[0] > crong[1] -> false
    else -> true
}

fun compareWhichIsBigNumber(pobysGreatestNum: Int, crongsGreatesNum: Int): Int {
    return when {
        (pobysGreatestNum == crongsGreatesNum) -> 0
        (pobysGreatestNum > crongsGreatesNum) -> 1
        else -> 2
    }
}

fun findGreatestPage(pageList: List<Int>): Int {
    var leftPage = pageList[0]
    var rightPage = pageList[1]
    var plusLeftPage = 0
    var mulLeftPage = 1
    var plusRightPage = 0
    var mulRightPage = 1

    while (leftPage > 0) {
        plusLeftPage += leftPage % 10
        mulLeftPage *= leftPage % 10
        leftPage /= 10
    }

    while (rightPage > 0) {
        plusRightPage += rightPage % 10
        mulRightPage *= rightPage % 10
        rightPage /= 10
    }

    leftPage = if (plusLeftPage > mulLeftPage) plusLeftPage else mulLeftPage
    rightPage = if (plusRightPage > mulRightPage) plusRightPage else mulRightPage
    return if (leftPage > rightPage) leftPage else rightPage
}
