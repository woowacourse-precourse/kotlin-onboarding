package onboarding

import java.util.*

fun solution3(number: Int): Int {
    val clabCountList: MutableList<Int> = ArrayList(Collections.nCopies(10003, -1))
    setSingleDigitCountList(clabCountList)
    return getSumClabCount(number, clabCountList)
}

fun setSingleDigitCountList(clabCountList: MutableList<Int>) {
    for (number in 1 until 10) {
        if (number % 3 == 0) clabCountList[number] = 1
        else clabCountList[number] = 0
    }
}

fun setCurrentNumberClabCount(currentNumber: Int, clabCountList: MutableList<Int>) {
    val unitDigit = currentNumber % 10

    clabCountList[currentNumber] = clabCountList[currentNumber / 10]
    if (unitDigit != 0 && (unitDigit % 3 == 0)) {
        clabCountList[currentNumber]++
    }
}

fun getSumClabCount(lastNumber: Int, clabCountList: MutableList<Int>): Int {
    var numberClabCount = 0

    for (currentNumber in 1..lastNumber) {
        if (currentNumber >= 10)
            setCurrentNumberClabCount(currentNumber, clabCountList)

        numberClabCount += clabCountList[currentNumber]
    }
    return numberClabCount
}