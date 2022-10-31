package onboarding

import kotlin.math.max

/*
 * solution1
 *
 * version 1.0
 *
 * 2022-10-26
 */
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isException(pobi) || isException(crong))
        return -1

    val pobiMax: Int = max(pageMaxNumber(pobi[0]), pageMaxNumber(pobi[1]))
    val crongMax: Int = max(pageMaxNumber(crong[0]), pageMaxNumber(crong[1]))

    return if (pobiMax > crongMax)
        1
    else if (pobiMax < crongMax)
        2
    else
        0
}

fun isException(list: List<Int>): Boolean {
    if(list[0] < 1 || list[1] > 400) return true
    if(list[0] % 2 != 1 || list[1] % 2 != 0) return true
    if(list[0] + 1 != list[1]) return true

    return false
}

fun pageMaxNumber(page: Int): Int {
    var now: Int = page
    var mul = 1
    var sum = 0

    do{
        mul *= now % 10
        sum += now % 10
        now /= 10
    }while (now != 0)

    return if(mul > sum)
        mul
    else
        sum
}
