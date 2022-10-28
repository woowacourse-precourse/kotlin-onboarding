package onboarding

fun solution3calcClapCount(number: Int): Int {
    return number.toString().count { c -> c == '3' } +
            number.toString().count { c -> c == '6' } +
            number.toString().count { c -> c == '9' }
}

fun solution3(number: Int): Int {
    var totalClapCount = 0
    for (eachNum in 1..number) {
        totalClapCount += solution3calcClapCount(eachNum)
    }

    return totalClapCount

}
