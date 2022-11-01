package onboarding

fun solution3(number: Int): Int {
    checkThrowException(number)
    return 0
}

private fun checkThrowException(number: Int) {
    throwNumberRangeException(number)
}

private fun throwNumberRangeException(number: Int) {
    if (number > 10000 || number < 1) throw error("number는 1 이상 10,000 이하인 자연수여야 합니다!")
}

private fun isContainedMultipleOfThree(number: Int): Boolean {
    if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) return true
    return false
}
