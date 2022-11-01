package onboarding

fun solution3(number: Int): Int {
    var threeCount = 0
    var sixCount = 0
    var nineCount = 0

    if (isCorrect(number)) {
        for (i in 1..number) {
            for (j in "$i") {
                if ('3' == j) threeCount++
                if ('6' == j) sixCount++
                if ('9' == j) nineCount++
            }

        }
        return threeCount + sixCount + nineCount
    } else return -1
}

fun isCorrect(number: Int): Boolean {
    val condition1 = number in 1..10000
    return condition1
}
