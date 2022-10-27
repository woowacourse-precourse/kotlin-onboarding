package onboarding

fun solution3(number: Int): Int {
    var count = 0
    for (num in 1..number) {
        count += containsNumber(num)
    }
    return count
}

fun containsNumber(num: Int): Int {
    var value = num
    var count = 0
    while (value != 0) {
        val item = value % 10
        if (item == 3 || item == 6 || item == 9) {
            ++count
        }
        value /= 10
    }
    return count
}


fun main() {
    println(solution3(33))
}