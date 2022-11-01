package onboarding

fun solution3(number: Int): Int {
    var count = 0
    for (i in 0..number) {
        var currentNum = i
        while (currentNum != 0) {
            if (currentNum % 10 == 3 || currentNum % 10 == 6 || currentNum % 10 == 9) {
                count++
            }
            currentNum /= 10
        }
    }
    return count
}
