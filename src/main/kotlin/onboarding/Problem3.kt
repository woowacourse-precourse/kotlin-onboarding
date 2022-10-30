package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

fun count(num: Int): Int {
    var input = num
    var cnt = 0
    while (input != 0) {
        if (input % 10 == 3 || input % 10 == 6 || input % 10 == 9)
            cnt++
        input /= 10
    }
    return cnt
}
