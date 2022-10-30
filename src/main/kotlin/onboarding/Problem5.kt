package onboarding

fun solution5(money: Int): List<Int> {

    var change = mutableListOf<Int>()
    var moneyList = arrayOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var temp = money

    for (i in moneyList.indices) {
        change.add(temp / moneyList[i])
        temp %= moneyList[i]
    }

    return change
}
