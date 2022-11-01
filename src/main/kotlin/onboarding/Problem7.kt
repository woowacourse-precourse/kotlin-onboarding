package onboarding

private const val TOGETHER_SCORE = 10
private const val VISITOR_SCORE = 1

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendSet = mutableSetOf<String>()
    val recommendedFriends = mutableMapOf<String, Int>()

    searchUserFriends(user, userFriendSet, friends)
    recommendedFriends.putAll(searchFriendsKnowTogether(user, userFriendSet, friends))
    checkVisitor(visitors, userFriendSet, recommendedFriends)

    val resultList = sortRecommendedFriends(recommendedFriends)
    return resultList.filterIndexed { index, _ -> index < 5 }
}

private fun searchUserFriends(user: String, userFriendSet: MutableSet<String>, relation: List<List<String>>) {
    for (list in relation) {
        if (list[0] == user) userFriendSet.add(list[1])
        if (list[1] == user) userFriendSet.add(list[0])
    }
}

private fun searchFriendsKnowTogether(
    user: String,
    userFriendSet: MutableSet<String>,
    relation: List<List<String>>
): Map<String, Int> {
    val recommendedFriends = mutableMapOf<String, Int>()
    for (list in relation) {
        if (user in list) continue
        if ((list[0] in userFriendSet) and (list[1] in userFriendSet)) continue
        if (list[0] in userFriendSet) plusScore(recommendedFriends, list[1], TOGETHER_SCORE)
        if (list[1] in userFriendSet) plusScore(recommendedFriends, list[0], TOGETHER_SCORE)
    }
    return recommendedFriends
}

private fun plusScore(recommendedFriends: MutableMap<String, Int>, name: String, score: Int) {
    recommendedFriends[name] = recommendedFriends[name]?.plus(score) ?: score
}

private fun checkVisitor(
    visitors: List<String>,
    userFriendSet: MutableSet<String>,
    recommendedFriends: MutableMap<String, Int>
) {
    visitors.forEach {
        if (it in userFriendSet) return@forEach
        plusScore(recommendedFriends, it, VISITOR_SCORE)
    }
}

private fun sortRecommendedFriends(recommendedFriends: MutableMap<String, Int>): List<String> {
    return recommendedFriends.toList()
        .sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }).map { it.first }
}
