package onboarding

fun solution3(number: Int): Int {

    var clapCount: Int = 0

    for (i in 1..number) {
        var currentNumber: Int = i
        val meetCriteriaClap = currentNumber % 10 == 3 || currentNumber % 10 == 6 || currentNumber % 10 == 9

        while (currentNumber != 0) {
            if (meetCriteriaClap) clapCount++
            currentNumber /= 10
        }
    }
    return clapCount
}
