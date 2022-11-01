package onboarding

import java.lang.Math.abs
import java.lang.Math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var answer = 0

    if (abs(pobi[0] - pobi[1]) != 1) {
        answer = -1
    } else if (abs(crong[0] - crong[1]) != 1) {
        answer = -1
    } else {
        val pobiConvert = pobi.map {
            var sumRes = 0
            var mulRes = 1

            it.toString().forEach {
                sumRes += it.digitToInt()
                mulRes *= it.digitToInt()
            }

            return@map max(sumRes, mulRes)
        }

        val crongConvert = crong.map {
            var sumRes = 0
            var mulRes = 1
            it.toString().forEach {
                sumRes += it.digitToInt()
                mulRes *= it.digitToInt()
            }
            return@map max(sumRes, mulRes)
        }

        var pobiScore = 0
        var crongScore = 0

        if (pobiConvert[0] > crongConvert[0]) {
            pobiScore++
        } else if (pobiConvert[0] < crongConvert[0]) {
            crongScore++
        }

        if (pobiConvert[1] > crongConvert[1]) {
            pobiScore++
        } else if (pobiConvert[1] < crongConvert[1]) {
            crongScore++
        }

        if (pobiScore > crongScore) {
            answer = 1
        } else if (pobiScore < crongScore) {
            answer = 2
        } else {
            answer = 0
        }
    }

    return answer
}
