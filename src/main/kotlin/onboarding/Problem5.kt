package onboarding
fun solution5(money: Int): List<Int> {
    var moneyresult = mutableListOf<Int>()
    var moneyvar: Int = money

    var nice = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (i in 0..8) {
        moneyresult.add(moneyvar / nice[i])
        moneyvar -= nice[i] * (moneyvar / nice[i])
    }
    return moneyresult
}