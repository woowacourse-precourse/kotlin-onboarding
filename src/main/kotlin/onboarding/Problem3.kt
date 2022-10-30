package onboarding

fun solution3(number: Int): Int {
    return loopCheck(number)
}

fun loopCheck(number: Int): Int {

    var count = 0
    for (i in 1..number) {
        var tempNumber = i

        while (tempNumber > 0) {
            if ((tempNumber % 10 == 3) or (tempNumber % 10 == 6) or (tempNumber % 10 == 9)) {
                count++
            }
            tempNumber /= 10
        }
    }
    return count
}
