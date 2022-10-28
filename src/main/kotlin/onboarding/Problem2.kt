package onboarding

import problem1.RangeVerifier
import java.lang.RuntimeException

fun solution2(cryptogram: String): String {
    val minLength = 1
    val maxLength = 1000
    val rangeVerifier = RangeVerifier(cryptogram.length, minLength, maxLength)
    if(!rangeVerifier.verify()) {
        throw RuntimeException("Input length is not between range $minLength and $maxLength")
    }

    return ""
}
