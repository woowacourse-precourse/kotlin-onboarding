package onboarding

fun solution3(number: Int): Int {
    val conditionSet = setOf(3, 6, 9)

    return (1..number).fold(0) { acc, i ->
        acc + getDigits(i).count { it in  conditionSet}
    }
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
