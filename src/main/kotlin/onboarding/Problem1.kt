package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // 포비의 페이지와 크롱의 페이지를 String으로 바꾼다.
    // 배열을 돌면서 각 자리수를 합하는 sum()을 구현한다.
    // 각 자리수를 곱하는 multiplication()을 구현한다.
    // 각 자리수를 합하거나 곱한거중 큰 수를 찾는다.
    // 포비와 크롱의 점수를 구한다.
    // 결과를 반환한다.

    val pobiToString = pobi.map { it.toString() }
    val crongToString = crong.map { it.toString() }

    val sumOfPobi = sum(pobiToString)
    val multipliOfPobi = multiplication(pobiToString)

    val sumOfCrong = sum(crongToString)
    val multipliOfCrong = multiplication(crongToString)

    val maxSumOfPobi = max(sumOfPobi[0], sumOfPobi[1])
    val maxMultipliOfPobi = max(multipliOfPobi[0], multipliOfPobi[1] )

    val maxSumOfCrong = max(sumOfCrong[0], sumOfCrong[1])
    val maxMultipliOfCrong = max(multipliOfCrong[0], multipliOfCrong[1])

    val scorOfPobi = max(maxSumOfPobi, maxMultipliOfPobi)
    val scoreOfCrong = max(maxSumOfCrong, maxMultipliOfCrong)

    return when {
        scorOfPobi < scoreOfCrong -> 2
        scorOfPobi > scoreOfCrong -> 1
        else -> 0
    }
}

private fun sum(list: List<String>): List<Int> {
    return list.map {
        var sum = 0
        it.forEach { char -> sum += char.digitToInt() }
        sum
    }
}

private fun multiplication(list: List<String>): List<Int> {
    return list.map {
        var multi = 1
        it.forEach { char -> multi *= char.digitToInt() }
        multi
    }
}