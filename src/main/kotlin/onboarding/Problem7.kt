package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    // friend map을 만든다.
    val friendsMap = getFriendsScore(friends)
    // friend에 user가 있는지 확인한다. 있으면 map에서 value를 +5
    // visitors에 있는 친구를 map에서 +1
    // map을 value값으로 정렬하고 같으면 이름으로 정렬한다.
    // map키를 5까지 출력한다.
    TODO("프로그램 구현")
}

private fun getFriendsScore(friends: List<List<String>>): Map<String, Int> {
    val map = mutableMapOf<String, Int>()
    friends.forEach { friend ->
        friend.forEach { name ->
            map.put(name, 0)
        }
    }
    return map
}
