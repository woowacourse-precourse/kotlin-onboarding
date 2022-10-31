package onboarding


fun solution3(number: Int): Int {
    return countNumberOfClaps(number)
}

fun count369(number: Int): Int {
    var count = 0
    val numberToString = number.toString()

    for (digit in numberToString) {
        if (digit == '3' || digit == '6' || digit == '9') {
            count++
        }
    }
    return count
}

fun countNumberOfClaps(number: Int): Int {
    var count = 0

    for (num in 1..number) {
        count += count369(num)
    }

    return count
}
