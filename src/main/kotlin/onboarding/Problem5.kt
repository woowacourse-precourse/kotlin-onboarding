package onboarding

fun solution5(money: Int): List<Int> {
    val moneys = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result: ArrayList<Int> = arrayListOf()
    var temp = money

    for (won in moneys) {
        result.add(temp / won)
        temp %= won
    }

    return result
}
