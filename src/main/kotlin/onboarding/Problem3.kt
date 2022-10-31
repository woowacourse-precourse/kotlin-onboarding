package onboarding

fun solution3(number: Int): Int {
    var result = 0
    for (i: Int in 0..number) {
        val n = i.toString()
        result += n.count { c -> c == '3' }
        result += n.count { c -> c == '6' }
        result += n.count { c -> c == '9' }
    }

    return result
}

fun main() {
    val number = 40

    println(solution3(number))
}