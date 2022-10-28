package onboarding

fun count369(num: Int): Int {
    var tmp = num
    var cnt = 0
    while (tmp > 0) {
        if (tmp % 10 == 3 || tmp % 10 == 6 || tmp % 10 == 9) cnt++
        tmp /= 10
    }
    return cnt
}

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}
