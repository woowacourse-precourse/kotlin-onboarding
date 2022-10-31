package onboarding

fun solution5(money: Int): List<Int> {
    val change = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    return exchange(money, change)
}

fun exchange(money: Int, change: List<Int>): List<Int> {
    var restMoney = money
    val result: MutableList<Int> = mutableListOf()
    for (i in change) {
        result.add(restMoney / i)
        restMoney %= i
    }
    return result
}