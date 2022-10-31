package onboarding

private var realMoney = 0
fun solution5(money: Int): List<Int> {
    realMoney = money
    val list = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    return mutableListOf<Int>().apply {
        list.forEach {
            add(calcMoney(it))
        }
    }
}

private fun calcMoney(cash: Int): Int =
    (realMoney / cash).also { realMoney %= cash }
