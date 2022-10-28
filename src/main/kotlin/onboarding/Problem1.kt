package onboarding

import java.lang.Integer.max

/*
기능 목록
- 각 자리 숫자를 더하거나 곱함
- 점수를 결정함
- 점수를 비교함
*/

fun processDigit(num: Int, operator: Int): Int {
    var n = num
    var r = n % 10
    while (true) {
        n /= 10
        if (n == 0) break
        if (operator == 0) r += n % 10
        else if (operator == 1) r *= n % 10
    }
    return r
}

fun determineScore(page: List<Int>): Int {
    if (page[1] - page[0] != 1) throw Exception()
    return max(
        max(processDigit(page[0], 0), processDigit(page[0], 1)),
        max(processDigit(page[1], 0), processDigit(page[1], 1))
    )
}

fun compareScore(pobiScore: Int, crongScore: Int): Int {
    return if (pobiScore > crongScore) 1
    else if (pobiScore < crongScore) 2
    else 0
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

}