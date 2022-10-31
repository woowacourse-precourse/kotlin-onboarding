package onboarding

import problem1.RangeVerifier
import problem2.AlphabetVerifier
import problem2.ConsecutiveDeduplicator
import problem2.LowerCaseVerifier
import problem2.StringLengthVerifier
import java.lang.RuntimeException

fun solution2(cryptogram: String): String {
    val inputValidator = InputValidator(
        listOf(
            StringLengthVerifier(1, 1000),
            AlphabetVerifier(),
            LowerCaseVerifier()
        )
    )

    inputValidator.validate(cryptogram)

    val consecutiveDeduplicator = ConsecutiveDeduplicator()

    return consecutiveDeduplicator.deduplicate(cryptogram)
}
