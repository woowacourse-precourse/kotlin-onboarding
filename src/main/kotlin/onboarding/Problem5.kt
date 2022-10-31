package onboarding

import problem1.RangeVerifier
import java.lang.RuntimeException

fun solution5(money: Int): List<Int> {
    val minRange = 1
    val maxRange = 1000000
    val rangeVerifier = RangeVerifier(money, minRange, maxRange)
    if(!rangeVerifier.verify()) {
        throw RuntimeException("Input is not between range $minRange and $maxRange")
    }

    return listOf()
}
