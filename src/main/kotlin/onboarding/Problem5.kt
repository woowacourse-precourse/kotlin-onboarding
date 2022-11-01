package onboarding

import java.util.*

fun solution5(money: Int): List<Int> {
    if (!isAppropriateMoney(money)) {
        return Collections.emptyList()
    }

    return Collections.emptyList()
}

fun isAppropriateMoney(money: Int): Boolean {
    if (money !in 1..1_000_000) {
        return false
    }
    return true
}
