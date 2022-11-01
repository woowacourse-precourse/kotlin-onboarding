package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriends = findUserFriends(user, friends)
}

fun findUserFriends(user: String,friends: List<List<String>>): MutableSet<String>{
    val userFriends = mutableSetOf<String>()
    friends.forEach{
        if(it[0] == user) {
            userFriends.add(it[1])
        } else if (it[1] == user) {
            userFriends.add(it[0])
        }
    }
    return userFriends
}