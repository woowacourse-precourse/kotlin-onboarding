package onboarding

fun solution5(money: Int): List<Int> {
    var change = money
    val result = mutableListOf<Int>()
    val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (i in moneyList){
        result += change / i
        change %= i
    }

    return result
}