package onboarding

fun solution3(number: Int): Int {
    var result = 0

    for (i in 1..number) {
        result += getClapCount(i)
    }

    return result
}

private fun getClapCount(number: Int): Int {
    var digit = number
    var result = 0
    while (digit != 0) {
        val remainder = digit % 10
        if (remainder != 0 && remainder % 3 == 0) {
            result++
        }
        digit /= 10
    }
    return result
}