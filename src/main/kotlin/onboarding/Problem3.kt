package onboarding

fun solution3(number: Int): Int {
    var endCount = 0

    for (i in 1..number) {
        endCount += numberCheck(i)
    }
    return endCount
}

fun numberCheck(thisNumber: Int): Int {
    var count = 0
    var tmp = thisNumber

    while (tmp != 0) {
        count += clapCheck(tmp % 10)
        tmp /= 10
    }
    return count
}

fun clapCheck(number: Int): Int {
    if (number == 3 || number == 6 || number == 9) {
        return 1
    }
    return 0
}
