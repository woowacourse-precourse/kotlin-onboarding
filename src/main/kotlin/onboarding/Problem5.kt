package onboarding

import problem1.RangeVerifier
import problem5.Bank
import java.lang.RuntimeException

fun solution5(money: Int): List<Int> {
    val inputValidator = InputValidator(
        listOf(
            RangeVerifier(1, 1000000)
        )
    )

    inputValidator.validate(money)

    val bank = Bank(money)
    return bank.withdraw()
}
