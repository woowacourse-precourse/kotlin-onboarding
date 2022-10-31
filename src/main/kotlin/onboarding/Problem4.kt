package onboarding

import problem1.RangeVerifier
import problem2.StringLengthVerifier
import problem4.ReverseAlphabet
import java.lang.RuntimeException

fun solution4(word: String): String {
    val inputValidator = InputValidator(
        listOf(
            StringLengthVerifier(1, 1000)
        )
    )

    inputValidator.validate(word)

    val reverseAlphabet = ReverseAlphabet(word)

    return reverseAlphabet.reverse()
}
