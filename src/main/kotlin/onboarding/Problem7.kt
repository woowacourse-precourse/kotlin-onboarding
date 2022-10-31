package onboarding

fun setUserFriends(infoFriends: List<List<String>>, user: String): List<String> {
    var result = mutableListOf<String>()

    for(i in infoFriends.indices) {
        if (infoFriends[i][0] == user) {
            result.add(infoFriends[i][1])
            continue
        }
        if(infoFriends[i][1] == user)
            result.add(infoFriends[i][0])
    }

    return result.toList()
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}
