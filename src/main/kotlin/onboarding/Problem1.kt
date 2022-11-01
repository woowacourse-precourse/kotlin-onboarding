package onboarding

import kotlin.math.max


fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    return gameResult(pobi, crong)
}

fun gameResult(pobi: List<Int>, crong: List<Int>): Int {
    val pobiScore = Comparator(digitPlus(pobi), digitMultiple(pobi))
    val crongScore = Comparator(digitPlus(crong), digitMultiple(crong))

    if ((checkListLength(pobi, crong) == -1) or (checkSerialPage(pobi, crong) == -1)) {
        return -1
    }

    if (pobiScore == crongScore) {
        return 0
    }

    return when (Comparator(pobiScore, crongScore)) {
        pobiScore -> 1
        crongScore -> 2
        else -> -1
    }

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

fun Comparator(a: Int, b: Int): Int {
    return max(a, b)
}


fun digitPlus(list: List<Int>): Int { // 각 페이지 자리수 더하기, 큰 수 리턴
    var leftPage = list[0]
    var rightPage = list[1]
    var resultLeftPage = 0
    var resultRightPage = 0

    while (leftPage != 0) {
        resultLeftPage += leftPage % 10
        leftPage /= 10
    }

    while (rightPage != 0) {
        resultRightPage += rightPage % 10
        rightPage /= 10
    }

    return Comparator(resultLeftPage, resultRightPage)
}

fun digitMultiple(list: List<Int>): Int {
    var leftPage = list[0]
    var rightPage = list[1]
    var resultLeftPage = 1
    var resultRightPage = 1

    while (leftPage != 0) {
        resultLeftPage *= leftPage % 10
        leftPage /= 10
    }

    while (rightPage != 0) {
        resultRightPage *= rightPage % 10
        rightPage /= 10
    }

    return Comparator(resultLeftPage, resultRightPage)
}