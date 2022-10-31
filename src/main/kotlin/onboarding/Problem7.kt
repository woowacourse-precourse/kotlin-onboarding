package onboarding

import problem2.AlphabetVerifier
import problem2.LowerCaseVerifier
import problem2.StringLengthVerifier

private fun validateUser(user:String) {
    val userValidator = InputValidator(
        listOf(
            StringLengthVerifier(1, 30),
            AlphabetVerifier(),
            LowerCaseVerifier()
        )
    )

    userValidator.validate(user)
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    validateUser(user)
    
    return listOf()
}
