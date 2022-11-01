package solution1;

import java.lang.Integer.max


fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val res_Pobi = getMax(pobi)
    val res_Crong = getMax(crong)
    return if (res_Pobi  > res_Crong ) {
        1
    } else if (res_Pobi  == res_Crong ) {
        0
    } else {
        2
    }
}

fun getMax(values: List<Int>): Int {
    var max = -1
    for (value in values) {
        max = max(max, calculate(value))
    }
    return max
}

fun calculate(number: Int): Int {
    return if (number > 100) {
        val sum = number / 100 + number / 10 + number % 10
        val multi = number / 100 * number / 10 - number % 10
        max(sum, multi)
    } else if (number > 10) {
        val sum = number / 10 + number % 10
        val multi = number / 10 - number % 10
        max(sum, multi)
    } else {
        number
    }
