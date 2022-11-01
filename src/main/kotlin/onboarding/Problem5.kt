package onboarding

fun solution5(money: Int): List<Int> {
    val table = listOf(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1)
    val ret = mutableListOf<Int>()
    var money = money
    for (i in table) {
        ret.add(money / i)
        money %= i
    }
    return ret
}
