package onboarding

fun solution5(money: Int): List<Int> {

    return splitUnit(money)
}

fun splitUnit(money: Int): MutableList<Int> {
    var myMoney = money
    val wallet: MutableList<Int> = mutableListOf()
    val currency = mutableListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (i in currency) {
        val change = myMoney / i
        if (change != 0) {
            wallet += change
            myMoney -= change * i
        } else wallet += 0


    }
    return wallet
}
