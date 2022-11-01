package onboarding

fun solution3(number: Int): Int {
    if (!isAppropriateNumber(number)) {
        return -1
    }

    var countNumberOf369 = 0
    val filterWith369 =
        (0..number).filter { it % 10 == 3 || it % 10 == 6 || it % 10 == 9 || it / 10 == 3 || it / 10 == 6 || it / 10 == 9 }

    for (element in filterWith369) {
        var element369 = element
        while (element369 > 0) {
            if (element369 % 10 == 3 || element369 % 10 == 6 || element369 % 10 == 9) {
                countNumberOf369++
            }
            element369 /= 10
        }
    }
    return countNumberOf369
}

fun isAppropriateNumber(number: Int) = when (number) {
    !in 1..10000 -> false
    else -> true
}
