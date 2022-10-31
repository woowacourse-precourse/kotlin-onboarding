package onboarding

import java.util.*

fun solution5(money: Int): List<Int> {
    val moneyUnitList = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    return getMoneyUnitCountList(money, moneyUnitList)
}

fun getMoneyUnitCountList(totalMoney: Int, moneyUnitList: List<Int>): List<Int> {
    val moneyUnitCountList: MutableList<Int> = ArrayList(Collections.nCopies(moneyUnitList.size, 0))

    var currentMoney = totalMoney
    for (moneyUnitIdx in moneyUnitList.indices) {
        val moneyUnit = moneyUnitList[moneyUnitIdx]
        moneyUnitCountList[moneyUnitIdx] = currentMoney / moneyUnit
        currentMoney -= moneyUnitCountList[moneyUnitIdx] * moneyUnit
    }

    return moneyUnitCountList
}