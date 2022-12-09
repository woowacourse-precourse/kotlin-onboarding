package onboarding

import kotlin.math.max


fun solution1(pobi: List<Int>, crong: List<Int>): Int { // 게임 결과값 리턴

    return gameResult(pobi, crong)
}

fun gameResult(pobi: List<Int>, crong: List<Int>): Int { // 예외사항 체크 및 승자에 따른 점수 리턴
    val pobiScore = comparator(digitPlus(pobi), digitMultiple(pobi))
    val crongScore = comparator(digitPlus(crong), digitMultiple(crong))

    if ((checkListLength(pobi, crong) == -1) or (checkSerialPage(pobi, crong) == -1)) {
        return -1
    }

    if (pobiScore == crongScore) {
        return 0
    }

    return when (comparator(pobiScore, crongScore)) {
        pobiScore -> 1
        crongScore -> 2
        else -> -1
    }

}


fun checkListLength(pobi: List<Int>, crong: List<Int>): Int { // 리스트 길이 검사
    if ((pobi.size != 2) or (crong.size != 2)) {
        return -1
    }
    return 0
}

fun checkSerialPage(pobi: List<Int>, crong: List<Int>): Int { // 연속되는 페이지 여부 검사
    if (((pobi[1] - pobi[0]) != 1) or ((crong[1] - crong[0]) != 1)) {
        return -1
    }
    return 0
}

fun comparator(a: Int, b: Int): Int { // 두 수 비교 후, 큰 값 출력
    return max(a, b)
}


fun digitPlus(list: List<Int>): Int { // 각 페이지 자리수 더하기
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

    return comparator(resultLeftPage, resultRightPage)
}

fun digitMultiple(list: List<Int>): Int { // 각 페이지 자리수 곱하기
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

    return comparator(resultLeftPage, resultRightPage)
}