package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

private fun getDigits(num: Int): List<Int> {
    val digits = mutableListOf<Int>()

    var digit = num
    while (digit > 0) {
        digits.add(digit % 10)
        digit /= 10
    }

    return digits
}
