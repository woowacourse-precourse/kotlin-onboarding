package onboarding

fun solution3(number: Int): Int {

    var clapCount: Int = 0

    for(increasedNumber in 1..number) {
        var currentNumber = increasedNumber

        while(currentNumber != 0) {
        val isMetCriteriaClap = currentNumber % 10 == THREE || currentNumber % 10 == SIX || currentNumber % 10 == NINE

            if(isMetCriteriaClap) {
                clapCount++
            }
            currentNumber /= 10
        }
    }

    return clapCount
}


const val THREE = 3
const val SIX = 6
const val NINE = 9