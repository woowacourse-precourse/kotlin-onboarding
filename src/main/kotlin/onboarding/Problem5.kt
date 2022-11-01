package onboarding

fun solution5(money: Int): List<Int> {

    val moneyList: List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val moneyCountList = mutableListOf<Int>()
    var restMoney = money

    moneyList.map {
        val moneyCount = restMoney / it
        val moneyCountIsZero = (moneyCount == 0)

        if (!moneyCountIsZero) {
            moneyCountList.add(moneyCount)
            restMoney -= moneyCount * it
        }

        if (moneyCountIsZero) {
            moneyCountList.add(0)
        }
    }

    return moneyCountList

}
