package onboarding

//- 사용자가 함께 아는 친구 목록 반환 기능
//- 사용자의 타임라인에 방문한 사람들과 그 횟수 구하는 기능
//- user 길이 제한 기능
//- friends 길이 제한 기능
//- visitors 길이 제한 기능
//- 사용자 아이디 알파벳 소문자 제한 기능
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun getFriends(friends: List<List<String>>): Set<String> {
    val friendsName = mutableSetOf<String>()
    friends.forEach { friend -> friendsName.add(friend[0]) }
    return friendsName
}

fun getFriendOfFriends(user: String, friends: List<List<String>>): List<String> {
    val friendOfFriends = mutableListOf<String>()
    friends.forEach { friend -> if (user != friend[1]) friendOfFriends.add(friend[1]) }
    return friendOfFriends
}
