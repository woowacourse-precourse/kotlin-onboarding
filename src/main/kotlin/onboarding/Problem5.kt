package onboarding

fun solution5(money: Int): List<Int> {
    val withdrawalList = List(9) { 0 }.toMutableList()
    val currencyList = mutableListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var idx = 0
    var moneyInAccount = money

    checkMoney(money)

    currencyList.forEach { currency ->
        while (moneyInAccount / currency > 0) {
            withdrawalList[idx] += 1
            moneyInAccount -= currency
        }
        idx += 1
    }

    return withdrawalList
}

/** 예외 처리 */
private fun checkMoney(money: Int) {
    if (money !in 1..1000000) {
        throw IllegalArgumentException(
            "money는 1 이상 1,000,000 이하인 자연수여야 합니다."
        )
    }
}
