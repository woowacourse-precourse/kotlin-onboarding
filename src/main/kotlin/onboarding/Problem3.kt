package onboarding

fun solution3(number: Int): Int {
    validateNumber(number)

    var count = 0

    for (num in 1..number) {
        count += clapCount(num)
    }

    return count
}

fun validateNumber(number: Int) {
    if (number !in 1..10000)
        throw IllegalArgumentException("숫자의 범위는 1 이상 10000 이하여야 합니다.")
}

fun clapCount(number: Int): Int = number.toString().count { c -> c == '3' || c == '6' || c == '9' }
