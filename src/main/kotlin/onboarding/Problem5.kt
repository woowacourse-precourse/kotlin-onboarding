package onboarding

fun solution5(money: Int): List<Int> {
    val answer = mutableListOf<Int>()
    // 현재 금액
    var nowMoney = money

    // 오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원
    val pay = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    for (i in pay) {
        //
        if (nowMoney / i > 0) {
            answer.add(nowMoney / i)
            nowMoney %= i
        } else {
            answer.add(0)
        }
    }
    return answer
}
