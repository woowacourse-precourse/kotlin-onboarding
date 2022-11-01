package onboarding

import problem2.AlphabetVerifier
import problem2.LowerCaseVerifier
import problem2.StringLengthVerifier
import problem6.ListSizeVerifier

private fun validateUserId(id:String) {
    val idValidator = InputValidator(
        listOf(
            StringLengthVerifier(1, 30),
            AlphabetVerifier(),
            LowerCaseVerifier()
        )
    )

    idValidator.validate(id)
}

private fun validateUser(user:String) {
    validateUserId(user)
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

private fun validateFriendInfo(friends:List<List<String>>) {
    for((user1, user2) in friends) {
        validateUserId(user1)
        validateUserId(user2)
    }
}

private fun validateVisitors(visitors: List<String>) {
    val listValidator = InputValidator(
        listOf(
            ListSizeVerifier(0, 10000)
        )
    )
    listValidator.validate(visitors)

    for(visitor in visitors) {
        validateUserId(visitor)
    }
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    validateUser(user)

    validateFriends(friends)

    validateFriendInfo(friends)

    validateVisitors(visitors)

    return listOf()
}
