package onboarding

fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")
}

private fun getMinimizedCoinList(money: Int): List<Int> {
    var currentMoney = money
    val coinTypeList = listOf(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1)
    val minimizedCoinList = mutableListOf<Int>()

    coinTypeList.forEach { coinType ->
        minimizedCoinList.add(currentMoney / coinType)
        currentMoney %= coinType
    }

    return minimizedCoinList
}