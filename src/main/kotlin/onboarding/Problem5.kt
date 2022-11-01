package onboarding

fun solution5(money: Int): List<Int> {
    val result = List(9) { 0 }.toMutableList()
    val moneyList = arrayListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var wallet = money

    while (wallet != 0){
        for (i in moneyList.indices) {
            result[i] = wallet / moneyList[i]
            wallet %= moneyList[i]
        }
    }

    return result
}
