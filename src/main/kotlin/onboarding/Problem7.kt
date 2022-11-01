package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    if (isAppropriateInput(user, friends, visitors).isNotEmpty()) {
        return isAppropriateInput(user, friends, visitors)
    }

    val friendScore = mutableMapOf<String, Int>()
    val alreadyFriend = mutableListOf(user)

    for (i in friends.indices) {
        if (user == friends[i].first()) {
            alreadyFriend.add(friends[i].last())
        } else if (user == friends[i].last()) {
            alreadyFriend.add(friends[i].first())
        }
    }
    for (i in friends.indices) {
        if (friendScore.contains(friends[i].first())) {
            friendScore[friends[i].first()] = friendScore[friends[i].first()]!! + 10
        } else {
            friendScore[friends[i].first()] = 10
        }
        if (friendScore.contains(friends[i].last())) {
            friendScore[friends[i].last()] = friendScore[friends[i].last()]!! + 10
        } else {
            friendScore[friends[i].last()] = 10
        }
    }
    for (i in visitors.indices) {
        if (friendScore.contains(visitors[i])) {
            friendScore[visitors[i]] = friendScore[visitors[i]]!! + 1
        } else {
            friendScore[visitors[i]] = 1
        }
    }

    for (i in alreadyFriend.indices) {
        friendScore.remove(alreadyFriend[i])
    }

    val friendReferralResult: Map<String, Int> =
        friendScore.toList().sortedBy { (key, _) -> key }.sortedByDescending { (_, value) -> value }.take(5).toMap()
    return friendReferralResult.keys.toList()
}

fun isAppropriateInput(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    if (user.length !in 1..30) {
        return listOf("user는 길이가 1 이상 30 이하인 문자열이어야 합니다.")
    }
    if (friends.size !in 1..10000) {
        return listOf("friends는 길이가 1 이상 10,000 이하인 리스트/배열이어야 합니다.")
    }
    if (visitors.size !in 0..10000) {
        return listOf("visitors는 길이가 0 이상 10,000 이하인 리스트/배열이어야 합니다.")
    }
    for (i in friends.indices) {
        if (friends[i].first().length !in 0..30 || friends[i].last().length !in 0..30) {
            return listOf("아이디는 길이가 1 이상 30 이하인 문자열이어야 한다.")
        }
    }
    return listOf()
}
