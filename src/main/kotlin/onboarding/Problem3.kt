package onboarding

fun solution3(number: Int): Int {
    return countClabNumber(number = number)
}

fun countClabNumber(number: Int): Int {
    val gameNumbers = listOf(THREE, SIX, NINE)
    var clabNumber = 0

    for (currentNum in 1..number) {
        clabNumber += currentNum.toString().count { eachNum ->
            gameNumbers.contains(eachNum)
        }
    }

    return clabNumber
}

const val THREE = '3'
const val SIX = '6'
const val NINE = '9'

