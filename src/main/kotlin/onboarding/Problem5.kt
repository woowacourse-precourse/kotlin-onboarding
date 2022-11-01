package onboarding

fun solution5(money: Int): List<Int> {
    checkMoney(money)

    var currentMoney = money
    val moneyCounts = MutableList(9) { 0 }
    val units = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    units.onEachIndexed { index, _ ->
        moneyCounts[index] = currentMoney / units[index]
        currentMoney %= units[index]
    }
    return moneyCounts.toList()
}

fun checkMoney(money: Int) {
    require(money in 1..1000000) { "money는 1 이상 1,000,000 이하인 자연수이다." }
}

