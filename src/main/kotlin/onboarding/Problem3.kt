package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

/**
 * 파라미터로 온 숫자에 3,6,9의 숫자가 몇개 포함되어있는지 반환한다.
 */
fun count369InNum(num: Int): Int {
    val numList = listOf(3, 6, 9)
    val cnt = 0
    while (num > 0) {
        if (num % 10 in numList) {
            cnt += 1
        }
        num /= 10
    }
    return cnt
}
