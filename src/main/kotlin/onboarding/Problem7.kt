package onboarding

const val FOLLOWER_SCORE = 10
const val DEFAULT_SCORE = 0

fun getFollower(friends: List<List<String>>) : MutableMap<String, MutableSet<String>>{
    val follower = mutableMapOf<String, MutableSet<String>>()

    for (element in friends) {
        val name = element[0]
        val friend = element[1]

        if (follower[name] == null)
            follower[name] = mutableSetOf()
        if (follower[friend] == null)
            follower[friend] = mutableSetOf()

        follower[friend]!!.add(name)
        follower[name]!!.add(friend)
    }
    return follower
}
fun calculateFollowerScore(user : String, follower : MutableMap<String, MutableSet<String>>, score: MutableMap<String, Int>){
    for (friends in follower[user]!!) {
        for (friend in follower[friends]!!) {
            if (friend != user && !follower[user]?.contains(friend)!!) {
                score[friend] = score.getOrDefault(friend, DEFAULT_SCORE) + FOLLOWER_SCORE
            }
        }
    }
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val follower = getFollower(friends)
    val score = mutableMapOf<String,Int>()
    calculateFollowerScore(user, follower, score)

    return listOf()
}