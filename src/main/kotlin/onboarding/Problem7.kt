package onboarding

import java.util.regex.Pattern

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    checkThrowException(user, friends, visitors)
    return listOf()
}

private fun checkThrowException(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
) {
    throwNicknameLengthException(user)
    throwFriendsSizeException(friends)
    throwVisitorsSizeException(visitors)

    friends.forEach { friend ->
        throwFriendFormException(friend.size)
        throwNicknameFormException(friend[0])
        throwNicknameFormException(friend[1])
        throwNicknameLengthException(friend[0])
        throwNicknameLengthException(friend[1])
    }

    visitors.forEach { visitor ->
        throwNicknameFormException(visitor)
        throwNicknameLengthException(visitor)
    }
}

private fun throwNicknameLengthException(user: String) {
    if (user.length > 30 || user.isEmpty()) throw error("아이디는 길이가 1 이상 30 이하인 문자열이어야 합니다!")
}

private fun throwFriendsSizeException(friends: List<List<String>>) {
    if (friends.size > 10_000 || friends.isEmpty()) throw error("friends는 길이가 1 이상 10,000 이하인 리스트/배열이어야 합니다!")
}

private fun throwVisitorsSizeException(visitors: List<String>) {
    if (visitors.size > 10_000) throw error("visitors는 길이가 0 이상 10,000 이하인 리스트/배열이어야 합니다!")
}

private fun throwFriendFormException(size: Int) {
    if (size != 2) throw error("friends의 각 원소는 길이가 2인 리스트/배열이어야 합니다!")
}

private fun throwNicknameFormException(user: String) {
    if (!Pattern.matches("^[a-z]*$", user)) throw error("사용자 아이디는 알파벳 소문자로만 이루어져 있어야 합니다!")
}
