package onboarding

fun solution3(number: Int): Int {
    var answer = 0
    var num = number
    while (num > 2) {
        answer += count369InNum(num)
        num -= 1
    }
    return answer
}

/**
 * 파라미터로 온 숫자에 3,6,9의 숫자가 몇개 포함되어있는지 반환한다.
 */
fun count369InNum(num: Int): Int {
    val numList = listOf(3, 6, 9)
    var number = num
    var cnt = 0
    while (number > 0) {
        if (number % 10 in numList) {
            cnt += 1
        }
        number /= 10
    }
    return cnt
}
