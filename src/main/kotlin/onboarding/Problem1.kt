package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // 포비의 페이지와 크롱의 페이지를 String으로 바꾼다.
    // 배열을 돌면서 각 자리수를 합하는 sum()을 구현한다.
    // 각 자리수를 곱하는 multiplication()을 구현한다.
    // 각 자리수를 합하거나 곱한거중 큰 수를 찾는다.
    // 결과를 반환한다.

    val pobiToString = pobi.map { it.toString() }
    val crongToString = crong.map { it.toString() }

    val sumOfPobi = sum(pobiToString)

    val sumOfCrong = sum(crongToString)


    return 0
}

private fun sum(list: List<String>): List<Int> {
    return list.map {
        var sum = 0
        it.forEach { char -> sum += char.digitToInt() }
        sum
    }
}