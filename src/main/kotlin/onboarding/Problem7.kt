package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    checkInputs(user, friends, visitors)

    val userAndFriendSet = friends.filter { it.contains(user) }.flatten().toSet()
    val userSet = setOf(user)
    val friendSet = userAndFriendSet.subtract(userSet)
    val recommendSet = friends.flatten().toSet().subtract(userAndFriendSet)

    val scores = mutableMapOf<String, Int>()
    val updatedScores =
        scores.getCommonFriendPoints(friendSet, recommendSet, friends).getVisitorPoints(visitors, friendSet).toList()
    return updatedScores.sortedBy { score -> score.first }.sortedByDescending { score -> score.second }.map { it.first }.take(5)
}

fun checkInputs(user: String, friends: List<List<String>>, visitors: List<String>) {

    require(user.length in 1..30) { "user는 길이가 1 이상 30 이하인 문자열이다." }
    require(friends.size in 1..10000) { "friends는 길이가 1 이상 10,000 이하인 리스트/배열이다." }
    require(friends.all { friend -> friend.all { it.length in 1..30 } }) { "friends의 각 원소는 길이가 2인 리스트/배열이고 아이디는 길이가 1 이상 30 이하인 문자열이다.." }
    require(visitors.size in 0..10000) { "visitors는 길이가 0 이상 10, 000 이하인 리스트/배열이다." }
}

private fun MutableMap<String, Int>.getCommonFriendPoints(
    friendSet: Set<String>,
    recommendSet: Set<String>,
    friends: List<List<String>>
): MutableMap<String, Int> {
    val recommends = recommendSet.toList()
    recommends.onEach { recommend ->
        this[recommend] = 0
        val commonFriend =
            friends.filter { relation -> relation.contains(recommend) }.flatten().toSet().subtract(setOf(recommend))
                .toList()
        this[recommend] = this[recommend]!! + commonFriend.count { it in friendSet } * 10
    }
    return this
}

private fun MutableMap<String, Int>.getVisitorPoints(
    visitors: List<String>,
    friendSet: Set<String>
): MutableMap<String, Int> {
    visitors.filter { it !in friendSet }.onEach { visitor ->
        if (this[visitor] == null) {
            this[visitor] = 1
        } else {
            this[visitor] = this[visitor]!! + 1
        }
    }
    return this
}
