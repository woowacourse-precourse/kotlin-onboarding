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
    var totalCnt = 0
    for (i in 1 until number + 1) {
        totalCnt += count369(i)
    }
    return totalCnt
}
