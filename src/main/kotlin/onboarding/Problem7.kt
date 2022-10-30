package onboarding

/*
 * 기능 요구 사항
 * 1. 사용자와 함께 아는 친구 10점, 타임 라인에 방문한 횟수 1점
 * 2. 친구 추천 규칙에 따라 점수가 높은 순으로 5명을 반환
 * 예외 사항
 * 1. 0점인 친구는 추천하지 않는다
 * 2. user 와 이미 친구인경우 추천하지 않는다
 * 3. 추천 점수가 같은 경우 이름순으로 정렬
 * 문제 풀이
 * 1. HashMap 으로 친구관계를 양방향으로 저장한다
 * 2. 친구의 친구에 대한 점수를 구해준다
 * 3. 방문 횟수에 따라 점수를 구해준다
 * 4. 점수와 이름으로 요구사항에 맞게 정렬 후 5명을 반환한다
 */
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

// 친구관계에 있어서 HashMap 을 통한 Relation 설정
private fun initFriendRelation(friends: List<List<String>>): HashMap<String, ArrayList<String>> {
    val friendRelation = HashMap<String, ArrayList<String>>()
    for (i in friends.indices) {
        val from = friendRelation.getOrDefault(friends[i][0], arrayListOf())
        val to = friendRelation.getOrDefault(friends[i][1], arrayListOf())
        from.add(friends[i][1])
        to.add(friends[i][0])
        friendRelation[friends[i][0]] = from
        friendRelation[friends[i][1]] = to
    }
    return friendRelation
}

private fun getScoreByFriends(
    user: String,
    friendsRelation: HashMap<String, ArrayList<String>>,
    score: HashMap<String, Int>
) {
    // user 와 친구관계가 있다면 다른 친구들과 함께 아는 친구를 확인해 본다
    if (friendsRelation[user] != null) {
        val userFriends = friendsRelation[user]
        for (key in friendsRelation.keys) {
            if (key != user && friendsRelation[key] != null) {
                // 같이 알고 있는 친구들의 수
                val knowTogether = (userFriends!! + friendsRelation[key]!!).groupBy { it }
                    .filter { it.value.size > 1 }
                    .flatMap { it.value }
                    .distinct()
                    .count()
                // user 와 같이 아는 친구의 수 만큼 10점 추가
                score[key] = knowTogether * 10
            }
        }
    }
}

private fun getScoreByVisitors(
    visitors: List<String>,
    userFriends: ArrayList<String>?,
    score: HashMap<String, Int>
) {
    val setOfVisitors = visitors.toSet()
    // 방문 휫수에 따라 1점 추가
    for (visitor in setOfVisitors) {
        if (userFriends != null) {
            if (userFriends.contains(visitor)) {
                continue
            }
        }
        // 이미 친구 관계라면
        val count = visitors.count { it == visitor }
        score[visitor] = score.getOrDefault(visitor, 0) + count
    }
}
