package onboarding

fun solution5(money: Int): List<Int> {
    val result = mutableListOf<Int>()
    val unitOfMoneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var nowMoney = money

    for (i in unitOfMoneyList.indices) {
        result.add(nowMoney/unitOfMoneyList[i])
        nowMoney %= unitOfMoneyList[i]
    }

    return result
}
