package onboarding

fun solution3(number: Int): Int {
    return threeSixNineClabs(number = number)
}

/* 박수 횟수 구하기 기능 */
fun threeSixNineClabs(number: Int): Int {
    val three = '3'
    val six = '6'
    val nine = '9'
    val targetNumber = listOf(three, six, nine)
    var clabNumber = 0

    for (num in 1..number) {
        clabNumber += num.toString().count { eachNum ->
            targetNumber.contains(eachNum)
        }
    }
    return clabNumber
}