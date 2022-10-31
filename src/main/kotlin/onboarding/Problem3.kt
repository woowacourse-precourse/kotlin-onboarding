package onboarding

fun solution3(number: Int): Int {
    var count = 0
    for (i in 1..number) {
        var digit = i
        while (digit != 0) {
            if (digit % 10 == 3 || digit % 10 == 6 || digit % 10 == 9) count++
            digit /= 10
        }
    }
    return count
}