package onboarding

fun solution3(number: Int): Int {
    var ans = 0

    for (i in 1..number) {
        val temp = i.toString().toCharArray()
        for (j in temp) {
            when (j) {
                '3' -> ans++
                '6' -> ans++
                '9' -> ans++
            }
        }
    }
    return ans
}

