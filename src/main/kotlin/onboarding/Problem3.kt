package onboarding

fun solution3(number: Int): Int {
    var count = 0

    for (i in 1 .. number) {
        var curNum = i

        while (curNum != 0) {
            if (curNum % 10 == 3 || curNum % 10 == 6 || curNum % 10 == 9) {
                count++
            }
            curNum /= 10
        }
    }
    return count
}