package onboarding

fun solution3(number: Int): Int {
    return countClap(number)
}

fun countClap(number: Int): Int {
    var cnt = 0
    val clapList = listOf('3','6','9')

    for(i in 1..number) {
        val digits = i.toString().toCharArray()
        cnt += digits.count { it in clapList }
    }

    return cnt
}
