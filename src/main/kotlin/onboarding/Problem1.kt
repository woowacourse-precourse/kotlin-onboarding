package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!isValid(pobi, crong)) {
        return -1
    }

    val pobiMaxScore = calcScore(pobi)
    val crongMaxScore = calcScore(crong)

    return if (crongMaxScore > pobiMaxScore) {
        2
    } else if (crongMaxScore < pobiMaxScore) {
        1
    } else if (crongMaxScore == pobiMaxScore) {
        0
    } else {
        -1
    }

}

private fun isValid(pobi: List<Int>, crong: List<Int>): Boolean {
    return if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) {
        false
    } else !(pobi[0] % 2 == 0 || crong[0] % 2 == 0) //왼쪽 페이지가 짝수이면 false, 아니면 true
}

private fun calcScore(list: List<Int>): Int {
    var maxScore = 0
    list.forEach { page ->
        var sum = 0
        var multi = 1
        page.toString().map {
            with(it.code - 48) {
                sum += this
                multi *= this
            }
        }
        maxScore = max(maxScore, max(sum, multi))
    }
    return maxScore
}
