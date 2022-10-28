package onboarding

import problem1.RangeVerifier
import java.lang.RuntimeException

fun solution3(number: Int): Int {
    val minRange = 1
    val maxRange = 10000
    val rangeVerifier = RangeVerifier(number, minRange, maxRange)
    if(!rangeVerifier.verify()) {
        throw RuntimeException("Input length is not between range $minRange and $maxRange")
    }

    return 0
}
