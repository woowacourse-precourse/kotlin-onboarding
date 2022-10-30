package onboarding

fun solution5(money: Int): List<Int> {
    val answer = mutableListOf<Int>()
    var changeMoney = money
    val unitMoney = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    for (i in unitMoney.indices) {
        if (changeMoney >= unitMoney[i]) {
            answer.add(changeMoney / unitMoney[i])
            changeMoney %= unitMoney[i]
        } else if (changeMoney < unitMoney[i]) {
            answer.add(0)
        }
    }
    return answer
}
