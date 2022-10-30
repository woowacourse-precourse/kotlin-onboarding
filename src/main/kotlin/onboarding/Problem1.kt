package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1) {
        return -1
    }
    if (pobi[0] % 2 != 1 || pobi[1] % 2 != 0 || crong[0] % 2 != 1 || crong[1] % 2 != 0) {
        return -1
    }
    val pobiMax = max(bigNumber(pobi[0]), bigNumber(pobi[1]))
    val crongMax = max(bigNumber(crong[0]), bigNumber(crong[1]))
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