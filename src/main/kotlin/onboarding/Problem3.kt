package onboarding

fun solution3(number: Int): Int {
    var result = 0

    for (i in 1..number) {
        var digit = i
        while (digit != 0) {
            if ((digit % 10 != 0) && ((digit % 10) % 3 == 0)) {
                result++
            }
            digit /= 10
        }
    }

    return result
}
