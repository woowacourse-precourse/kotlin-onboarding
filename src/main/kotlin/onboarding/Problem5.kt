package onboarding

fun solution5(money: Int): List<Int> {

    val moneyList: List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val moneyCountList = mutableListOf<Int>()
    var restMoney = money

    moneyList.map {
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
