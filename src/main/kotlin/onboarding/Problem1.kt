package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    fun gameResult(pages: List<Int>): Int {

        val left = pages[0].toString().chunked(1)
        val right = pages[1].toString().chunked(1)

        val left_split: Array<Int> = left.map(String::toInt).toTypedArray()
        val right_split: Array<Int> = right.map(String::toInt).toTypedArray()

        val left_plus = left_split.sum()
        val right_plus = right_split.sum()

        var left_multi = 1
        var right_multi = 1
        for(i in left_split) {
            left_multi *= i
        }
        for(j in right_split) {
            right_multi *= j
        }

        val max_left = arrayOf(left_plus, left_multi).maxOrNull()
        val max_right = arrayOf(right_plus, right_multi).maxOrNull()

        return 0
    }

    return TODO("Provide the return value")
}
