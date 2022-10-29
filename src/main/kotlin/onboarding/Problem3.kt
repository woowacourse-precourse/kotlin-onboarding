package onboarding

fun solution3(number: Int): Int {
    var count = 0

    for (i in 0..number) {
        var i: Int = i

        while (i != 0) {
            when (i % 10) {
                3, 6, 9 -> {
                    count++
                }
            }
            i /= 10
        }
    }

    return count
}
