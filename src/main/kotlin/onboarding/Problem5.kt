package onboarding

fun solution5(money: Int): List<Int> {
    val unitList = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    return convertMoney(money, unitList)
}

private fun convertMoney(money: Int, unitList: List<Int>): List<Int> {
    var input = money
    val resultList = mutableListOf<Int>()

    unitList.forEach {
        resultList.add(input / it)
        input %= it
    }

    return resultList
}