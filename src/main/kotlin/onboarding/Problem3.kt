package onboarding

/**
기능 목록
- 1부터 number까지의 수 중 각 자리의 수에 3, 6, 9가 들어가는 횟수 count
- count한 값 모두 누적해서 더하기
 */

fun solution3(number: Int): Int {
    var answer = 0
    for (num in 1..number) {
        answer += num.toString().count { i -> i == '3' || i == '6' || i == '9' }
    }
    return answer
}
