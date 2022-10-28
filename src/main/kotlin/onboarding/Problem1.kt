package onboarding

import kotlin.math.max


fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
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