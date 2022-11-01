package onboarding

/* 화폐단위별로 몇 개씩인지 금액 큰 순서대로 반환하는 solution 기능 */
fun solution5(money: Int): List<Int> {
    var money = money
    val answer: MutableList<Int> = ArrayList()
    val moneyArr = intArrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var i = 0
    while (money != 0) {
        answer.add(money / moneyArr[i])
        money = money % moneyArr[i]
        i++
    }
    while (moneyArr.size != answer.size)
        answer.add(0)

    return answer
}
