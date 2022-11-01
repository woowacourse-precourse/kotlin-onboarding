package onboarding


fun solution5(money: Int): List<Int> {
    return convert(money)
}

private fun convert(money: Int): List<Int> {
    val changeArray = arrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result = mutableListOf<Int>()

    var tempMoney = money
    changeArray.forEach { change ->
        result.add(tempMoney / change)
        tempMoney -= (change * (tempMoney / change))
    }

    return result
}
