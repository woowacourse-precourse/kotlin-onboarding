package onboarding

fun solution3(number: Int): Int {
    return calculateClap(number)
}

private fun calculateClap(number: Int): Int {
    var clapCount = 0
    for (i in 1..number) {
        separateDigit(i).forEach { clapCount += checkClap(it) }
    }
    return clapCount
}

private fun separateDigit(number: Int): List<Int> {
    var input = number
    val digitList = mutableListOf<Int>()
    while (input != 0) {
        digitList.add(input % 10)
        input /= 10
    }
    return digitList
}

private fun checkClap(x: Int): Int {
    val gameList = listOf<Int>(3, 6, 9)
    return if (x in gameList) 1
    else 0
}
