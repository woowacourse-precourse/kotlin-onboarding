package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) {
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
