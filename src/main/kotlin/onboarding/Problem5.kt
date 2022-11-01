package onboarding

import java.util.*

fun solution5(money: Int): List<Int> {
    if (!isAppropriateMoney(money)) {
        return Collections.emptyList()
    }

    val numberOfCurrencies = MutableList(9) { 0 }
    val typeOfCurrency = arrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    numberOfCurrencies[0] = money / typeOfCurrency[0]
    for (i in 1 until typeOfCurrency.size) {
        numberOfCurrencies[i] = money % typeOfCurrency[i - 1] / typeOfCurrency[i]
    }
    return numberOfCurrencies
}

fun isAppropriateMoney(money: Int): Boolean {
    if (money !in 1..1_000_000) {
        return false
    }
    return true
}
