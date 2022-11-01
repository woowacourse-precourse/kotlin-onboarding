package onboarding

fun solution3(number: Int): Int {
    return calcThreeSixNineRepeat(number)
}

private fun calcThreeSixNineRepeat(number: Int): Int {
    var result = 0
    for (i in 1..number) {
        var stepNumber = i
        while (stepNumber != 0) {
            val processedStepNumber = stepNumber % 10
            if (processedStepNumber == 3 || processedStepNumber == 6 || processedStepNumber == 9) result += 1
            stepNumber /= 10
        }
    }
    return result
}
