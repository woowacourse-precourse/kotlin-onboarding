package onboarding

fun solution3(number: Int): Int {

}

fun loopCheck(number: Int) {

    var count = 0

    for (i in 1..number) {
        var tempNumber = i

        while (tempNumber > 0) {
            if ((i % 10 == 3) or (i % 10 == 6) or (i % 10 == 9)) {
                count++
            }
            tempNumber /= 10
        }
    }

}
