package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var scores = initScore(user, friends)
    scores = updateScore(visitors, scores)
}

fun updateScore(visitors: List<String>, scores: MutableMap<String, Int>): MutableMap<String, Int> {
    for(visitor in visitors) {
        scores[visitor] = scores[visitor]!!.plus(1)
    }
}

fun initScore(user: String, friends: List<List<String>>): MutableMap<String, Int> {
    val scores = mutableMapOf<String, Int>()

    for(friend in friends) {
        val user1 = friend[0]
        val user2 = friend[1]

        if(user1 == user) {
            scores[user2] = 10
        } else if(user2 == user) {
            scores[user1] = 10
        }
    }

    return scores
}