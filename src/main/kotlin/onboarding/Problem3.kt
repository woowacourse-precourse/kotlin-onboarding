package onboarding

fun solution3(number: Int): Int {
    var cnt = 0
    for (i in 1..number) {
        val numberString = i.toString()
        cnt += numberString.count { findMatched(it) }
    }
    return cnt
}

fun findMatched(char: Char): Boolean {
    return char == '3' || char == '6' || char == '9'
}