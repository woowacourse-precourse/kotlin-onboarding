package onboarding
/*
    기능 목록
    1. 유저의 친구 목록을 만드는 함수 searchFriends
    2. 친구의 친구일 경우 점수를 계산하는 함수 friendsScore
    3. 방문자의 방문 횟수를 계산하는 함수 visitorScore
    4. 점수에 따라 정렬하는 함수 sortedByScore
 */
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendSet = mutableSetOf<String>()
    val friendMap: Map<String, Int>
    // 유저의 친구 목록을 만듬
    searchFriends(friends, user, friendSet)
    // 친구의 친구 점수
    friendMap = friendsScore(friends, friendSet, user)
    // 방문자의 점수
    visitorScore(visitors, friendSet, friendMap)
    // 점수에 따른 정렬
    return sortedByScore(friendMap)
}

private fun searchFriends(
    friends: List<List<String>>,
    user: String,
    friendSet: MutableSet<String>
) {
    friends.forEach { friend ->
        if (friend[1] == user || friend[0] == user) {
            friendSet += friend[0]
        }
    }
}