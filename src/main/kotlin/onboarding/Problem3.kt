package onboarding

fun solution3(number: Int): Int {
    var clap = 0
    for (num in 1..number) {
        for (i in num.toString()) {
            if (i == '3' || i == '6' || i == '9')
                clap++
        }
    }
    return clap
}
