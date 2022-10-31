package onboarding

fun solution5(money: Int): List<Int> {
    val answer = mutableListOf<Int>()
    val typeOfMoney = listOf<Int>(50000,10000,5000,1000,500,100,50,10)
    var restOfMoney = money

    for (i in typeOfMoney.indices) {
        answer.add(restOfMoney/typeOfMoney[i])
        restOfMoney %= typeOfMoney[i]
    }
    answer.add(restOfMoney)

    return answer
}
