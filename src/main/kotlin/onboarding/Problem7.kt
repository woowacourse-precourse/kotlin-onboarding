package onboarding

import problem2.AlphabetVerifier
import problem2.LowerCaseVerifier
import problem2.StringLengthVerifier
import problem6.ListSizeVerifier

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

private fun validateFriends(friends: List<List<String>>) {
    val friendsValidator = InputValidator(
        listOf(
            ListSizeVerifier(1, 10000)
        )
    )
    friendsValidator.validate(friends)

    val friendValidator = InputValidator(
        listOf(
            ListSizeVerifier(2, 2)
        )
    )
    for(friend in friends) {
        friendValidator.validate(friend)
    }
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    validateUser(user)

    validateFriends(friends)

    return listOf()
}
