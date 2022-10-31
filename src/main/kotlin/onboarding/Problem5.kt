package onboarding

fun solution5(money: Int): List<Int> {
    val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result = MutableList(9) { 0 }
    var target = money

    for ((index, value) in moneyList.withIndex()) {
        if (target == 0) break
        val num = target / value
        result[index] = num
        target -= num * value
    }
    return result
}
