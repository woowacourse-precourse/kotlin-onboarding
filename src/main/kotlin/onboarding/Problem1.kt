package onboarding

/**
 * 기능 요구 사항
 * 1. 예외사항
 *      - 시작혹은 마지막으로 펼치지 않는다.
 *      - 왼쪽은 홀수, 오른쪽은 짝수어야한다.
 *      - 페이지 이므로 연속적이어야 한다.
 * 2. 가장 큰 수 구하기
 * 3. 점수를 비교하여 게임의 승자 결정
 */
fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    TODO("프로그램 구현")
}

private fun checkInputException(input: List<Int>): Boolean {
    return input[0] in 3..397 && input[1] in 4.. 398 &&
            input[1] - input[0] == 1 && input[0] % 2 == 1 && input[1] % 2 == 0
}

private fun getMaxScore(page: String): Int {
    // 각자리의 합과 곱에 대한 변수 설정
    var sum = 0
    var multi = 1
    for (i in page.toCharArray()) {
        sum += (i - '0')
        multi *= (i - '0')
    }
    // 더 큰값 반환
    return sum.coerceAtLeast(multi)
}

private fun winner(pobiScore: Int, crongScore: Int): Int {
    // pobi win : 1
    // crong win : 2
    // pobi = crong : 0
    return if (pobiScore > crongScore) {
        1
    } else if (pobiScore < crongScore) {
        2
    } else
        0
}
