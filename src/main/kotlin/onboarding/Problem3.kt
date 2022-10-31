package onboarding

fun solution3(number: Int): Int {
    var answer = 0
    for (i in 1..number) {
        if (checkContained(i)) {
            answer += countAnswer(i)
        }
    }
    return answer
}

fun checkContained(x: Int): Boolean {
    val stringX = x.toString()
    return stringX.contains(Regex("[369]"))
}

fun countAnswer(x: Int): Int {
    val stringX = x.toString()
    return Regex("[369]").findAll(stringX).count()
}