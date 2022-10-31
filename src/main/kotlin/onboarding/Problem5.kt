package onboarding

import java.util.LinkedList

fun solution5(money: Int): List<Int> {
    val cost = arrayListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    return shareMoney(money, cost)
}

fun shareMoney(money : Int, cost : ArrayList<Int>) : List<Int>{
    var m = money
    val answer = LinkedList<Int>()

    cost.forEach { i ->
        answer.add(m / i)
        m %= i
    }

    return answer
}
