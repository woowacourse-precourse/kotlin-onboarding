package onboarding

/*
 * 기능 요구 사항
 * 1. 주어진 돈에 대해서 각 돈을 몇번 사용하였는지 확인
 * 풀이 방법
 * 1. 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 동전에 대한 배열 선언
 * 2. 가장 큰 돈부터 차례대로 사용을 하면서 개수를 반환
 */

fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")
}

private fun moneyToEachDollarsList(money: Int, dollars: List<Int>): List<Int> {
    var totalMoney = money
    // 변환하려는 돈의 크기만큼 리스트 초기화
    val dollarCount = IntArray(dollars.size) { 0 }
    // 금액 변환
    for (i in dollars.indices) {
        dollarCount[i] = totalMoney / dollars[i]
        // 계좌에 남은 돈
        totalMoney %= dollars[i]
    }
    return dollarCount.toList()
}
