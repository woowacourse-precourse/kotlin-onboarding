package onboarding

/**
 * @author onseok
 */
fun solution5(money: Int): List<Int> {
    val coins = intArrayOf(
        50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1
    )
    var moneyRemained = money
    val result = IntArray(coins.size)
    for (i in coins.indices) {
        result[i] = moneyRemained / coins[i]
        moneyRemained %= coins[i]
    }
    return result.toList()
}