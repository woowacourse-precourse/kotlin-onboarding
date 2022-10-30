package onboarding

fun solution3(number: Int): Int {
    return gameProgress(number)
}

fun gameProgress(number: Int): Int {
    var num = number
    var count = 0
    while (num > 0) {
        count += checkClap(num)
        num--
    }
    return count
}

fun checkClap(num: Int): Int {
    val numToString = num.toString()
    return numToString.count { c -> c == '3' || c == '6' || c == '9' }
}
