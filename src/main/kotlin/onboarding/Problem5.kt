package onboarding

fun solution5(money: Int): List<Int> {
    var temp = money
    val coins = intArrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (i in coins) {
        val value = temp / i
        if (value != 0) {
            temp -= value * i
        }
    }
}
