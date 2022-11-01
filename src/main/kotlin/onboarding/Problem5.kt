package onboarding

fun solution5(money: Int): List<Int> {
    checkThrowException(money)
    return calculateCurrency(money)
}

private fun checkThrowException(money: Int) {
    throwNumberRangeException(money)
}

private fun throwNumberRangeException(number: Int) {
    if (number > 1_000_000 || number < 1) throw error("money는 1 이상 1,000,000 이하인 자연수여야 합니다!")
}

private fun calculateCurrency(money: Int): List<Int> {
    val currencies = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result = mutableListOf<Int>()
    var remain = money

    currencies.forEach{ currency ->
        result.add(remain / currency)
        remain %= currency
    }

    return result
}
