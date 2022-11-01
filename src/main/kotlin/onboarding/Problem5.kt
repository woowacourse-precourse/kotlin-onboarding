package onboarding

fun solution5(money: Int): List<Int> {
    return culCntOfMoneyUnits(money)
}

fun culCntOfMoneyUnits(money: Int): List<Int> {
    val units = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var cntOfMoneyUnits = arrayListOf<Int>()
    var balance = money

    for(unit in units) {
        cntOfMoneyUnits.add(balance/unit)
        balance %= unit
    }

    return cntOfMoneyUnits
}