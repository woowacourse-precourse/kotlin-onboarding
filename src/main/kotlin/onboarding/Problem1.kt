package onboarding

import kotlin.math.max

fun findMaxNum(pages: List<Int>): Int {
    var maxNum = 0

    for (i: Int in 0..1) {
        val lst = mutableListOf<Int>()
        var k = pages[i]
        while (k >= 10) {
            lst.add(k % 10)
            k /= 10
        }
        lst.add(k)

        val s = lst.sum()
        var m = 1
        for (n in lst)
            m *= n
        maxNum = max(maxNum, max(m, s))
    }
    
    return maxNum
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1)
        return -1
    if (pobi[0] > 399 || pobi[1] > 400 || crong[0] > 399 || crong[1] > 400)
        return -1

    val p = findMaxNum(pobi)
    val c = findMaxNum(crong)

    if (p > c) {
        return 1
    } else if (c > p) {
        return 2
    } else {
        return 0
    }
}

fun main() {
    val pobi = listOf<Int>(131, 132)
    val crong = listOf<Int>(211, 212)
    println(solution1(pobi, crong))
}