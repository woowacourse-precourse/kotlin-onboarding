package onboarding

fun solution5(money: Int): List<Int> {
    var money = money
    val moneyTypes = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val answer = moneyTypes.map { it * 0 }.toMutableList()

    while (money > 0) {
        for (i in moneyTypes.indices) {
            while (money >= moneyTypes[i]) {
                money -= moneyTypes[i]
                answer[i]++
            }
        }
    }
    return answer
}
