package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val userFriends = mutableListOf<String>()

    // user와 친구인 사용자를 찾는 기능
    friends.forEach {
        when (user) {
            it[0] -> userFriends.add(it[1])
            it[1] -> userFriends.add(it[0])
        }
    }

    return listOf()

}
