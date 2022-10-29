package onboarding

fun solution5(money: Int): List<Int> {
    var bills = mutableListOf<Int>()
    var moneys = mutableListOf(
        50000,
        10000,
        5000,
        1000,
        500,
        100,
        50,
        10
    )
    var leftMoney: Int = money
    var i = 0

    while (i < 8) {
        bills.add(leftMoney / moneys[i])
        leftMoney -= bills[i] * moneys[i]
        i++
    }

    bills.add(leftMoney)

    return bills
}
