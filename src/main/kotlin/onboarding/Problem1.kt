package onboarding

import java.lang.Integer.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

}

fun compareNum(person: List<Int>): Int {
    return max(calMax(person[0]), calMax(person[0]))
}

fun calMax(now: Int): Int {
    var plus = 0
    var mul = 1
    var temp = now
    while (temp > 0) {
        val cur = temp % 10

        mul *= cur
        plus += cur
        temp /= 10
    }
    return max(mul, plus)
}
