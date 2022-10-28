package onboarding

fun solution3(number: Int): Int {
    var answer = 0
    for (i in 1..number) {
        if (isContained(i)) {
            answer += count(i)
        }
    }
    return answer
}

fun isContained(x: Int): Boolean {
    return x.toString().contains(Regex("[369]"))
}

fun count(x: Int): Int {
    return Regex("[369]").findAll(x.toString()).count()
}