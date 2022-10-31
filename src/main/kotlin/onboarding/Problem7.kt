package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>,
): List<String> {
    val userFriends = mutableSetOf<String>()
    val recommendScore = mutableMapOf<String, Int>()

    for (friend in friends) {
        when (user) {
            friend[0] -> userFriends.add(friend[1])
            friend[1] -> userFriends.add(friend[0])
        }
    }

    for (friend in friends) {
        when {
            friend[0] in userFriends && user != friend[1] -> recommendScore[friend[1]] =
                recommendScore.getOrDefault(friend[1], 0) + 10
            friend[1] in userFriends && user != friend[0] -> recommendScore[friend[0]] =
                recommendScore.getOrDefault(friend[0], 0) + 10
        }
    }

    for (visitor in visitors) {
        when (visitor) {
            !in userFriends -> recommendScore[visitor] = recommendScore.getOrDefault(visitor, 0) + 1
        }
    }

    return recommendScore.toList().sortedByDescending { it.second }.map { it.first }.take(5)
}

