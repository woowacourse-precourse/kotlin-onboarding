package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun friendList(user: String, friends: List<List<String>>): MutableSet<String> {
    val friend = mutableSetOf<String>()
    friends.forEach {
        when (user) {
            it[0] -> friend.add(it[1])
            it[1] -> friend.add(it[0])
        }
    }
    return friend
}