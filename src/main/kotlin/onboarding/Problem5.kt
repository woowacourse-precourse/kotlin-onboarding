package onboarding

fun solution5(money: Int): List<Int> {
    val conversionToIndexMap = getConversionToIndexMap()
    return calcUnitCount(money, conversionToIndexMap)
}

private fun getConversionToIndexMap(): MutableMap<Int, Int> {
    val conversionToIndexMap = mutableMapOf<Int, Int>()
    val moneyUnitList = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (i in moneyUnitList.indices)
        conversionToIndexMap[moneyUnitList[i]] = i

    return conversionToIndexMap
}

private fun calcUnitCount(money: Int, conversionToIndexMap: MutableMap<Int, Int>): List<Int> {
    val unitCount = mutableListOf<Int>()
    var processedMoney = money

    conversionToIndexMap.forEach {
        unitCount.add(processedMoney / it.key)
        processedMoney %= it.key
    }

    return unitCount
}
