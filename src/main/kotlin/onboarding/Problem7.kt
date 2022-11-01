package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

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