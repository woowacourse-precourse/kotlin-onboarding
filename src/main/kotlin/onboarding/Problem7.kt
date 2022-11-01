package onboarding

import java.util.regex.Pattern

const val CONNECTED = 10
const val VISITED = 1

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    checkThrowException(user, friends, visitors)
    return recommendNewFriends(user, friends, visitors)
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

private fun recommendNewFriends(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val result = mutableListOf<String>()
    val myFriends = mutableListOf<String>()
    val newFriends = mutableMapOf<String, Int>()

    friends.forEach { friend ->
        when (user) {
            friend[0] -> myFriends.add(friend[1])
            friend[1] -> myFriends.add(friend[0])
        }
    }

    friends.forEach { other ->
        if (other[1] != user && myFriends.contains(other[0]) && !myFriends.contains(other[1])) {
            newFriends[other[1]] = newFriends[other[1]]?.plus(CONNECTED) ?: CONNECTED
        } else if (other[0] != user && !myFriends.contains(other[0]) && myFriends.contains(other[1])) {
            newFriends[other[0]] = newFriends[other[0]]?.plus(CONNECTED) ?: CONNECTED
        }
    }

    visitors.forEach { visitor ->
        if (!myFriends.contains(visitor)) {
            newFriends[visitor] = newFriends[visitor]?.plus(VISITED) ?: VISITED
        }
    }

    result.addAll(newFriends.toList()
        .sortedByDescending { (key, value) -> value }
        .toMap().keys)
    return result
}
