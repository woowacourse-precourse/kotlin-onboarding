package onboarding

import java.lang.Integer.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    if(pobi[1]-pobi[0]!=1 || crong[1]-crong[0]!=1){
        return -1
    }
    val resOfPobi = getMax(pobi)
    val resOfCrong = getMax(crong)
    return if (resOfPobi > resOfCrong) {
        1
    } else if (resOfPobi == resOfCrong) {
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
        val sum = (number / 100) + (number%100 / 10) + (number % 10)
        val multi = (number / 100) * (number%100/ 10) * (number % 10)
        max(sum, multi)
    } else if (number > 10) {
        val sum = number / 10 + number % 10
        val multi = (number / 10) * (number % 10)
        max(sum, multi)
    } else {
        number
    }
}
