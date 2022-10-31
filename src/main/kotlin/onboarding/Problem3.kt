package onboarding

import java.util.*

fun solution3(number: Int): Int {
    val clabCountList: MutableList<Int> = ArrayList(Collections.nCopies(10003, -1))
    setSingleDigitCountList(clabCountList)
    return 0
}

fun setSingleDigitCountList(clabCountList: MutableList<Int>) {
    for (number in 1 until 10) {
        if (number % 3 == 0) clabCountList[number] = 1
        else clabCountList[number] = 0
    }
}