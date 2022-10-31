package onboarding

import kotlin.math.abs

/**
 * @author onseok
 */

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi.isException() || crong.isException()) {
        return -1
    }
    return when (pobi.maxValue() - crong.maxValue()) {
        0 -> 0
        in 1 .. Int.MAX_VALUE -> 1
        else -> 2
    }
}

fun List<Int>.isException(): Boolean {
    return if (this.size != 2) false else {
        if (this.first() % 2 != 1) false else {
            abs(this.first() - this.last()) != 1
        }
    }
}

fun List<Int>.maxValue(): Int {
    val arr = intArrayOf(0, 1, 0, 1)
    this.first().toString().forEach {
        arr[0] += it.digitToInt()
        arr[1] *= it.digitToInt()
    }
    this.last().toString().forEach {
        arr[2] += it.digitToInt()
        arr[3] *= it.digitToInt()
    }
    arr.sort()
    return arr.last()
}