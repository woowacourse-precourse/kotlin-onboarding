package onboarding

fun solution3(number: Int): Int {
    if (!isAppropriateNumber(number)) {
        return -1
    }

    var countNumberOf369 = 0
    return -1
}

fun isAppropriateNumber(number: Int): Boolean {
    if (number !in 1..10000) {
        return false
    }
    return true
}
