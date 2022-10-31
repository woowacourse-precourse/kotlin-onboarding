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
        val max_plus = arrayOf(left_plus, right_plus).maxOrNull()

        return TODO("Provide the return value")

    }

    return TODO("Provide the return value")
}
