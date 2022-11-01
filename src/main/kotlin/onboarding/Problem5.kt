package onboarding

fun solution5(money: Int): List<Int> {
    val resultList = mutableListOf<Int>()
    val unitMoney = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var remain = money

    for (i in unitMoney.indices) {
        val currentUnit = unitMoney[i]
        resultList.add( remain / currentUnit )
        remain %= currentUnit
    }

    return resultList
}
