package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

fun max(a: Int, b: Int): Int {
    return if (a >= b) a else b
}

fun bigNumber(num: Int): Int {
    var input = num
    var pSum = 0
    var mSum = 1
    while (input != 0) {
        pSum += input % 10
        mSum *= input % 10
        input /= 10
    }
    return max(pSum, mSum)
}