package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    return listOf()
}

fun getFriendList(user: String, friends: List<List<String>>): HashSet<String> {
    val friendList = hashSetOf<String>()

    for (friend in friends) {
        when (user) {
            friend[0] -> friendList.add(friend[1])
            friend[1] -> friendList.add(friend[0])
        }
    }

    return friendList
}


