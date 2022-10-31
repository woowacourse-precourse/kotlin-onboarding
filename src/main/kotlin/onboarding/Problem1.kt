package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if (pobi[1]-pobi[0] != 1 || crong[1]-crong[0] != 1 || pobi[1] == 1 || crong[1] == 1 || pobi[0] == 400 || crong[0] == 400) {
        return -1
    }

    fun gameResult(pages: List<Int>): Int {

        val left = pages[0].toString().chunked(1)
        val right = pages[1].toString().chunked(1)

        val left_split: Array<Int> = left.map(String::toInt).toTypedArray()
        val right_split: Array<Int> = right.map(String::toInt).toTypedArray()

        val left_plus = left_split.sum()

        var left_multi = 1
        for(i in left_split) {
            left_multi *= i
        }

        val max_left = arrayOf(left_plus, left_multi).maxOrNull()

        return 0
    }

    return TODO("Provide the return value")
}
