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

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

}