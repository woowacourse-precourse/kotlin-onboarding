package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    // 연속되지 않는 페이지면 예외처리를 한다.
    if(pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) {
        return -1
    }
    // 포비의 페이지와 크롱의 페이지를 String으로 바꾼다.
    val pobiToString = pobi.map { it.toString() }
    val crongToString = crong.map { it.toString() }

    // 배열을 돌면서 각 자리수를 합하는 sum()을 구현한다.
    val sumOfPobi = sum(pobiToString)
    val sumOfCrong = sum(crongToString)

    // 각 자리수를 곱하는 multiplication()을 구현한다.
    val multipliOfPobi = multiplication(pobiToString)
    val multipliOfCrong = multiplication(crongToString)

    // 각 자리수를 합하거나 곱한거중 큰 수를 찾는다.
    val maxSumOfPobi = max(sumOfPobi[0], sumOfPobi[1])
    val maxMultipliOfPobi = max(multipliOfPobi[0], multipliOfPobi[1] )

    val maxSumOfCrong = max(sumOfCrong[0], sumOfCrong[1])
    val maxMultipliOfCrong = max(multipliOfCrong[0], multipliOfCrong[1])

    val scorOfPobi = max(maxSumOfPobi, maxMultipliOfPobi)
    val scoreOfCrong = max(maxSumOfCrong, maxMultipliOfCrong)

    // 결과를 반환한다.
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