package onboarding

fun getClap(number: Int): Int {
    var clapCnt = 0
    var remain = number
    while(remain != 0) {
        if(remain % 10 == 3 || remain % 10 == 6 || remain % 10 == 9) clapCnt += 1
        remain /= 10
    }
    return clapCnt
}

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}
