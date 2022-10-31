package onboarding

fun solution5(money: Int) {
    val conversionToIndexMap = getConversionToIndexMap()
}

private fun getConversionToIndexMap(): MutableMap<Int, Int> {
    val conversionToIndexMap = mutableMapOf<Int, Int>()
    val moneyUnitList = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (i in moneyUnitList.indices)
        conversionToIndexMap[moneyUnitList[i]] = i

    return conversionToIndexMap
}
