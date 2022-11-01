package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
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
