package onboarding

val currency = arrayListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 10, 1)

fun getCountMoney(idx: Int, money: Int):Int {
    return money / currency[idx]
}

fun getNowMoney(idx: Int, money: Int):Int {
    return money - (getCountMoney(idx, money) * currency[idx])
}

fun solution5(money: Int): List<Int> {
    var result = mutableListOf<Int>()

    return result
}
