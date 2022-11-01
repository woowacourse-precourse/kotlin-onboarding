package onboarding

fun solution5(money: Int): List<Int> {
    val moneyUnitList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    return calcUnitCount(money, moneyUnitList)
}

private fun calcUnitCount(money: Int, moneyUnitList: List<Int>): List<Int> {
    val unitCount = mutableListOf<Int>()
    var processedMoney = money

    moneyUnitList.forEach {
        unitCount.add(processedMoney / it)
        processedMoney %= it
    }

    return unitCount
}
