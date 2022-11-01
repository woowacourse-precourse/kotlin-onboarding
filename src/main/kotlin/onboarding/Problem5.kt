package onboarding

/**
기능 목록
- 현재 돈을 단위로 나눈 몫을 리스트에 담기
- 현재 돈을 나눈 나머지로 초기화
 */

fun solution5(money: Int): List<Int> {
    val answer = mutableListOf<Int>()
    var currentMoney = money
    val unitMoney = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (unit in unitMoney) {
        answer.add(currentMoney / unit)
        currentMoney %= unit
    }

    return answer
}
