package onboarding

import problem1.RangeVerifier
import problem3.Game369
import java.lang.RuntimeException

fun solution3(number: Int): Int {
    val inputValidator = InputValidator(
        listOf(
            RangeVerifier(1, 10000)
        )
    )

    inputValidator.validate(number)

    val game369 = Game369()

    return game369.count369(1, number)
}
