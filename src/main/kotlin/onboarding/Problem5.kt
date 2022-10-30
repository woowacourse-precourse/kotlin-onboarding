package onboarding

fun convert(money: Int): List<Int> {
    val changeArray = arrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result = mutableListOf<Int>()

    var tempMoney = money
    for (change in changeArray) {
        result.add(tempMoney / change)
        tempMoney -= (change * (tempMoney / change))
    }
    return result
}

fun solution5(money: Int): List<Int> {
    return convert(money)
}
