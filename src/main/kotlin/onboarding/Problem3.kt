package onboarding

fun solution3(number: Int): Int {
    if (!isAppropriateNumber(number)) {
        return -1
    }

    var countNumberOf369 = 0
    val filterWith369 = (0..number).filter { it % 10 == 3 || it % 10 == 6 || it % 10 == 9 || it / 10 == 3 || it / 10 == 6 || it / 10 == 9 }

    return -1
}

fun isAppropriateNumber(number: Int): Boolean {
    if (number !in 1..10000) {
        return false
    }
    return true
}
