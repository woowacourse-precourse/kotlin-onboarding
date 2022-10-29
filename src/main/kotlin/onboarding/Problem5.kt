package onboarding

fun solution5(money: Int): List<Int> {

    val moneyList = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val moneyCountList = mutableListOf<Int>()
    var restMoney = money

    moneyList.map { it }.forEach {
        val moneyCount = restMoney / it

        if (moneyCount != 0) {
            moneyCountList.add(moneyCount)
            restMoney -= moneyCount * it
        }

        if (moneyCount == 0) {
            moneyCountList.add(0)
        }
    }

    return moneyCountList

}
