package onboarding
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

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val follower = getFollower(friends)

    return listOf()
}