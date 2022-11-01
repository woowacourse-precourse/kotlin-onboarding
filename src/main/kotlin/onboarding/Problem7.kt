package onboarding

private const val TOGETHER_SCORE = 10

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendList = mutableListOf<String>()
    val recommendedFriends = mutableMapOf<String, Int>()

    searchUserFriends(user, userFriendList, friends)
    recommendedFriends.putAll(searchFriendsKnowTogether(user, userFriendList, friends))
}

private fun searchUserFriends(user: String, userFriendList: MutableList<String>, relation: List<List<String>>) {
    for (list in relation) {
        if (list[0] == user) userFriendList.add(list[1])
        if (list[1] == user) userFriendList.add(list[0])
    }
}

private fun searchFriendsKnowTogether(
    user: String,
    userFriendList: MutableList<String>,
    relation: List<List<String>>
): Map<String, Int> {
    val recommendedFriends = mutableMapOf<String, Int>()
    for (list in relation) {
        if (user in list) continue
        if ((list[0] in userFriendList) and (list[1] in userFriendList)) continue
        if (list[0] in userFriendList) plusScore(recommendedFriends, list[1], TOGETHER_SCORE)
        if (list[1] in userFriendList) plusScore(recommendedFriends, list[0], TOGETHER_SCORE)
    }
    return recommendedFriends
}

private fun plusScore(recommendedFriends: MutableMap<String, Int>, name: String, score: Int) {
    recommendedFriends[name] = recommendedFriends[name]?.plus(score) ?: score
}
