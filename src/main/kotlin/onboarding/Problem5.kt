package onboarding

/**
 * 제약조건 검사 함수
 * - money는 1 이상 1,000,000 이하인 자연수이다.
 *
 * @author @ponopono0322
 * @param money 출금액
 * @return true: 제약조건 충분, false: 제약조건 불충분
 */
fun constraintsS5(money: Int) = money in 1 .. 1_000_000

/**
 * Solution Algorithm
 * 1. 화폐 목록 초기화
 * 2. 제약조건 검사 및 잔돈, 정답 배열 초기화
 * 3. 화폐 단위로 잔돈을 나눠 몫은 배열에 추가, 나머지는 잔돈으로 갱신
 * 4. 정답 반환
 *
 * @author @ponopono0322
 * @param money 확인할 금액
 * @return 최소 화폐 목록
 */
fun solution5(money: Int): List<Int> {
    // 화폐 리스트
    val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    if (!constraintsS5(money)) return moneyList.map { 0 }   // 조건 불 충분시

    var change = money  // 잔돈 초기화
    val answer = mutableListOf<Int>()

    moneyList.forEach { i ->
        answer.add(change / i)
        change %= i
    }

    return answer
}
