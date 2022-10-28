package onboarding

import problem1.RangeVerifier
import problem2.AlphabetVerifier
import problem2.LowerCaseVerifier
import java.lang.RuntimeException

fun solution2(cryptogram: String): String {
    val minLength = 1
    val maxLength = 1000
    val rangeVerifier = RangeVerifier(cryptogram.length, minLength, maxLength)
    if(!rangeVerifier.verify()) {
        throw RuntimeException("Input length is not between range $minLength and $maxLength")
    }

    val alphabetVerifier = AlphabetVerifier(cryptogram)
    if(!alphabetVerifier.verify()) {
        throw RuntimeException("Input is not alphabet only")
    }

    val lowerCaseVerifier = LowerCaseVerifier(cryptogram)
    if(!lowerCaseVerifier.verify()) {
        throw RuntimeException("Input is not lowercase only")
    }

    return ""
}
