package onboarding

fun solution5(money: Int): List<Int> {
    var variableMoney = money
    val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    // 자리 수마다 따 와서 계산
    val moneyNum = MutableList<Int>(9) { 0 }
    for (i in 0 until moneyList.size) {
        if (variableMoney >= moneyList[i]) {
            moneyNum[i] = variableMoney / moneyList[i]
            variableMoney -= moneyNum[i] * moneyList[i]
        }
    }
    return moneyNum
}