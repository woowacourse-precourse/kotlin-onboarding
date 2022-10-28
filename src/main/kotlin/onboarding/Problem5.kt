package onboarding

fun solution5(money: Int): List<Int> {
    val moneyList = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    return convertMoney(money, moneyList)
}

fun convertMoney(x: Int, moneyList: List<Int>): List<Int> {

    val result = MutableList<Int>(9) { 0 }
    var target = x

    for ((index, money) in moneyList.withIndex()) {
        if (target == 0) break
        val mok = target / money
        result[index] = mok
        target -= mok * money
    }
    return result
}
