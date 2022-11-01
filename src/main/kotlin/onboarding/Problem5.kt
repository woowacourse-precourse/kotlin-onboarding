package onboarding

fun solution5(money: Int): List<Int> {
    checkThrowException(money)
    return listOf()
}

private fun checkThrowException(money: Int) {
    throwNumberRangeException(money)
}

private fun throwNumberRangeException(number: Int) {
    if (number > 1_000_000 || number < 1) throw error("money는 1 이상 1,000,000 이하인 자연수여야 합니다!")
}
