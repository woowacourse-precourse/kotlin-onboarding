package onboarding

import java.util.*

fun solution5(money: Int): List<Int> {
    val answer = LinkedList<Int>()
    val units = intArrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var n = money

    for (unit in units) {
        answer.add(n / unit)

        n %= unit
    }

    return answer
}