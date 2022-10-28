package onboarding

fun solution7(
//추천 점수 계산
fun countScore( user: String, friends: List<List<String>>, visitors: List<String>, usersFriend: List<String>, score: HashMap<String, Int>) {
    countFriendScore(user, usersFriend, friends, score)
    countVisitScore(visitors, score, usersFriend)
}

    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}
