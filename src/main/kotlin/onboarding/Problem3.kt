package onboarding


fun solution3(number: Int): Int {
    return countNumberOfClaps(number)
}

private fun count369(number: Int): Int {
    var count = 0
    val numberToString = number.toString()

    numberToString.forEach { digit ->
        if (digit == '3' || digit == '6' || digit == '9') {
            count++
        }
    }

    return count
}

private fun countNumberOfClaps(number: Int): Int {
    var count = 0

    for (num in 1..number) {
        count += count369(num)
    }

    return count
}
