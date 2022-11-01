package onboarding

import kotlin.math.max

fun checkException(left: Int, right: Int): Boolean {
    if (left == 1 || right == 400)
        return false
    if (right - left != 1)
        return false
    if (left % 2 != 1 || right % 2 != 0)
        return false
    return true


}

fun getScore(number: Int): Int {
    //모두 더하거나
    val sumResult = number.toString().map{ it.digitToInt()}
        .reduce{acc, i->acc + i}

//모두 곱한다.
    val multiResult = number.toString().map{ it.digitToInt()}
        .reduce{acc, i->acc * i}

//둘 중 가장 큰수를 본인의 점수로 한다.
    return max(sumResult, multiResult)
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    //정수가 들어있는 배열을 받음

    if (!checkException(pobi[0], pobi[1]) || !checkException(crong[0], crong[1]))
        return -1

    val pobiScore =max(getScore(pobi[0]),getScore(pobi[1]))
    val crongScore =max(getScore(crong[0]),getScore(crong[1]))

    //문제에서 제시한 result값 주기
    return when {
        pobiScore > crongScore -> 1
        pobiScore < crongScore -> 2
        else -> 0
    }
}