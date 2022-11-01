package onboarding

fun solution3(number: Int): Int {

    var clapA: Int = 0
    var clapB: Int = 0
    var clapC: Int = 0
    var clapD: Int = 0
    var result = 0

    if (number in 1..10000) {
        for (i in 1..number) {
            val temp = i/10
            if (i < 10) {
                if (i == 3 || i == 6 || i == 9) {
                    clapA += 1
                }
            }
            else if (i >= 10 && temp % 3 != 0) {
                if ((i % 10 == 3) || (i % 10 == 6) || (i % 10 == 9)) {
                    clapB += 1
                }
            }
            else if (temp % 3 == 0) {
                clapC += 1
                if ((i % 10 == 3) || (i % 10 == 6) || (i % 10 == 9)) {
                    clapD += 1
                }
            }
    }
    }

    println(clapA)
    println(clapB)
    println(clapC)
    println(clapD)
    result = clapA+clapB+clapC+clapD
    return result

}
