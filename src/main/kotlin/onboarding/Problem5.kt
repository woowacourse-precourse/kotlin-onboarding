package onboarding

fun solution5(money: Int): List<Int> {
    var bills = mutableListOf<Int>()
    var leftMoney: Int = money

    bills.add(leftMoney/50000)
    leftMoney -= bills[0] * 50000

    bills.add(leftMoney/10000)
    leftMoney -= bills[1] * 10000

    bills.add(leftMoney/5000)
    leftMoney -= bills[2] * 5000

    bills.add(leftMoney/1000)
    leftMoney -= bills[3] * 10000

    bills.add(leftMoney/500)
    leftMoney -= bills[4] * 500

    bills.add(leftMoney/100)
    leftMoney -= bills[5] * 100

    bills.add(leftMoney/50)
    leftMoney -= bills[6] * 50

    bills.add(leftMoney/10)
    leftMoney -= bills[7] * 10

    bills.add(leftMoney)

    return bills
}
