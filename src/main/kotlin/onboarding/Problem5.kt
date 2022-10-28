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
    var now_money = money

    for(i in 0 until currency.size) {
        result.add(i, getCountMoney(i, now_money))
        now_money = getNowMoney(i, now_money)
    }

    return result
}
