package onboarding

fun solution3(number: Int): Int {


    var clapCount: Int = 0

    for (i in 1..number) {
        var currentNumber: Int = i
        while (currentNumber != 0) {
            val meetCriteriaClap = currentNumber % 10 == 3 || currentNumber % 10 == 6 || currentNumber % 10 == 9

            if (meetCriteriaClap) clapCount++
            currentNumber /= 10
        }
    }
    return clapCount
}
