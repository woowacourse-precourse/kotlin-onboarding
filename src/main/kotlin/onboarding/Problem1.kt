package onboarding

import kotlin.math.max


fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiScore = max(digitPlus(pobi), digitMultiple(pobi))
    val crongScore = max(digitPlus(crong), digitMultiple(crong))

    if ((checkListLength(pobi, crong) == -1) or (checkSerialPage(pobi, crong) == -1)) {
        return -1
    }

    if (pobiScore == crongScore) {
        return 0
    } else if (pobiScore > crongScore) {
        return 1
    }
    return 2
}

fun checkListLength(pobi: List<Int>, crong: List<Int>): Int {
    if ((pobi.size != 2) or (crong.size != 2)) {
        return -1
    }
    return 0
}

fun checkSerialPage(pobi: List<Int>, crong: List<Int>): Int {
    if (((pobi[1] - pobi[0]) != 1) or ((crong[1] - crong[0]) != 1)) {
        return -1
    }
    return 0
}

fun digitPlus(list: List<Int>): Int {
    var leftPage = list[0]
    var rightPage = list[1]
    var plusLeftResult = 0
    var plusRightResult = 0

    while (leftPage != 0) {
        plusLeftResult += leftPage % 10
        leftPage /= 10
    }

    while (rightPage != 0) {
        plusRightResult += rightPage % 10
        rightPage /= 10
    }

    return max(plusLeftResult, plusRightResult) // kotlin max 문법찾기
}

fun digitMultiple(list: List<Int>): Int {
    var leftPage = list[0]
    var rightPage = list[1]
    var plusLeftResult = 1
    var plusRightResult = 1

    while (leftPage != 0) {
        plusLeftResult *= leftPage % 10
        leftPage /= 10
    }

    while (rightPage != 0) {
        plusRightResult *= rightPage % 10
        rightPage /= 10
    }

    return max(plusLeftResult, plusRightResult)
}