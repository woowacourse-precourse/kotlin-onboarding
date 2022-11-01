package onboarding

// 기능 목록
// 1. 사용할 화폐의 종류를 나열한 리스트 생성
// 2. 1번 리스트를 반복하며 각 화폐로 나누는 메소드 구현
// 3. 2번 메소드로 반환된 값을 반환하는 구문 구현

// 기능 목록 1번
private val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
fun solution5(money: Int): List<Int> {
    return exchangeMoney(money)
}

// 기능 목록 2번
private fun exchangeMoney(money: Int): List<Int> {
    var tempMoney = money
    val result = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    for ((index, currency) in moneyList.withIndex()) {
        result[index] = tempMoney / currency
        tempMoney -= currency * result[index]
    }

    return result.toList()
}