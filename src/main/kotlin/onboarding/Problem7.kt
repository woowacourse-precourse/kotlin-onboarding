package onboarding

fun solution7(
//추천 점수 계산
fun countScore( user: String, friends: List<List<String>>, visitors: List<String>, usersFriend: List<String>, score: HashMap<String, Int>) {
    countFriendScore(user, usersFriend, friends, score)
    countVisitScore(visitors, score, usersFriend)
}

//user 의 친구 찾기
fun findFriend(user: String, friends: List<List<String>>): List<String> {
    val usersFriend = mutableListOf<String>()
    for (f in friends) {
        if (f.contains(user)) {
            if (f.indexOf(user) == 0) {
                usersFriend.add(f[1])
            } else {
                usersFriend.add(f[0])
            }
        }
    }
    return usersFriend
}

    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}
