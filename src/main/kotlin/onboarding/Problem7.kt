package onboarding

/*
기능 목록
- 사용자 친구 목록 구하기
- 모든 추천 친구 목록 구하기
- 친구 추천 점수 결정
- 추천 친구 목록 출력
*/
val usersFriends = mutableListOf<String>()
val friendsRecommendScore = mutableMapOf<String, Int>()

fun getFriendList(user: String, friends: List<List<String>>) {
    for (i in friends) {
        if (i.contains(user)) {
            val friendIdx = 1 - i.indexOf(user)
            usersFriends.add(i[friendIdx])
        }
    }
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}
