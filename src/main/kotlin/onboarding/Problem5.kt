package onboarding

fun solution5(money: Int): List<Int> {
    val res = mutableListOf<Int>()
    var mutableMoney = money
    val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    moneyList.forEach {
        res.add(mutableMoney / it)
        mutableMoney %= it
    }
    return res
}
