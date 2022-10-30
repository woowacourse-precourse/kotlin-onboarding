package onboarding

import problem1.RangeVerifier
import problem4.ReverseAlphabet
import java.lang.RuntimeException

fun solution4(word: String): String {
    val minRange = 1
    val maxRange = 1000
    val rangeVerifier = RangeVerifier(word.length, minRange, maxRange)
    if(!rangeVerifier.verify()) {
        throw RuntimeException("Input length is not between range $minRange and $maxRange")
    }

    val reverseAlphabet = ReverseAlphabet()
    reverseAlphabet.reverse(word)

    return ""
}
