package onboarding

import kotlin.math.max

/**
 * 제약 조건 함수
 *
 * - pobi와 crong의 길이는 2이다.
 * - 페이지 번호가 1부터 시작되는 400 페이지의 책
 * - pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
 * - 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 *
 * @author @ponopono0322
 * @param pages (왼쪽 페이지 번호, 오른쪽 페이지 번호) 리스트
 * @return true: 요구조건 만족시, false: 요구조건 불만족시
 */
fun constraintsS1(pages: List<Int>): Boolean {
    if (pages.size != 2) return false
    if (pages.first() !in 1..400) return false
    if (pages.last() !in 1..400) return false
    if (pages.first() % 2 != 1 || pages.last() % 2 != 0) return false
    if (pages.first() + 1 != pages.last()) return false
    // if (pages.first() == 1 || pages.last() == 400) return false

    return true
}


/**
 * 각 자리를 더하거나 곱해 최대값을 찾아내는 함수
 *
 * @author @ponopono0322
 * @param n 페이지 번호
 * @param mode +: 더하기, *: 곱하기
 * @return 곱셈 혹은 덧셈 결과값
 */
fun getSum(n: Int, mode: String): Int {

    var total = if (mode == "+") 0 else 1  // mode에 따라 초기값 지정
    var m = n   // n 나누기 위한 변수

    while (m > 0) {
        when (mode) {
            "+" -> total += m % 10  // 각 자리 더하기
            "*" -> total *= m % 10  // 각 자리 곱하기
        }
        m /= 10     // 10으로 나눈 몫
    }

    return total
}

/**
 * 숫자 비교하여 최대값을 찾아내는 함수
 *
 * @author @ponopono0322
 * @param a 왼쪽 페이지 각 자리 더한 값
 * @param b 왼쪽 페이지 각 자리 곱한 값
 * @param c 오른쪽 페이지 각 자리 더한 값
 * @param d 오른쪽 페이지 각 자리 곱한 값
 * @return 최대값
 */
fun getMax(a: Int, b: Int, c: Int, d: Int): Int = max(max(a, b), max(c, d))

/**
 * Solution Algorithm
 *
 * 1. 제약 조건 확인 (미충족시 -1 반환)
 * 2. 규칙에 의한 최대값 구하기
 * 3. 비교 및 반환
 */
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // 조건 불충분 시 -1 반환
    if (!constraintsS1(pobi) || !constraintsS1(crong)) { return -1 }

    // pobi의 최대값
    val pobiMax = getMax(getSum(pobi[0], "+"), getSum(pobi[0], "*"),
                         getSum(pobi[1], "+"), getSum(pobi[1], "*"))
    // crong의 최대값
    val crongMax = getMax(getSum(crong[0], "+"), getSum(crong[0], "*"),
                          getSum(crong[1], "+"), getSum(crong[1], "*"))

    return if (pobiMax > crongMax) 1 else if (pobiMax < crongMax) 2 else 0

}
