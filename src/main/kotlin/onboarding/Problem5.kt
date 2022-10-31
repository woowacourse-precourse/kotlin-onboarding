package onboarding

fun solution5(money: Int): List<Int> {
    // 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
    val unitList = intArrayOf(50000, 10000, 5000, 100, 500, 100, 50, 10, 1)
    val answer = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var leftMoney = money
    for (i in 0..answer.size) {
        answer[i] += changesCount(leftMoney, unitList[i])
        leftMoney = changesMoney(leftMoney, unitList[i])
    }
    return answer
}

/**
 * 돈의 단위와 금액을 입력받아 변환값을 리턴한다.
 */
fun changesCount(money: Int, unit: Int): Int = money / unit

/**
 * 돈의 단위와 금액을 입력받아 남은 금액을 리턴한다.
 */
fun changesMoney(money: Int, unit: Int): Int = money % unit


