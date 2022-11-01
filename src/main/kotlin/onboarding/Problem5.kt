package onboarding

fun solution5(money: Int): List<Int> {

    return exchangeCoin(money)
}

fun exchangeCoin(money: Int): List<Int> {
    var money: Int = money
    var wallet = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)
    val coin: List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (i in coin.indices) {
        if (money >= coin[i]) {
            wallet[i] = money / coin[i]
            money %= coin[i]
        }
    }
    return wallet
}