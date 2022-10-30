package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    // 추천 받을 유저의 친구 목록

    // 친구들의 친구 목록 - 유저의 친구 목록 -> Set

    // 리스트 저장
    // +10

    // 방문자 목록 - 유저의 친구 목록

    // +1

    // 정렬

    TODO()
}

private class User(val name: String, var score: Int = 0)

private fun getUserFriends(user: String, friends: List<List<String>>): Set<String> {
    TODO()
}

private fun getSharedFriends(friends1: List<List<String>>, friends2: List<List<String>>): List<String> {
    TODO()
}