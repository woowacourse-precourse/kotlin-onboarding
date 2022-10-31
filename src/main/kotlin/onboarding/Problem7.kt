package onboarding


// 친구별 점수 map
private var friendScoreMap = hashMapOf<String, Int>()

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    // user의 친구는 친구 추천에서 제외해야 되기 때문에 true로 구분
    val userFriendMap = hashMapOf<String, Boolean>()
    for (i in friends) {
        if (user in i) {
            for (j in i) {
                if (user != j) userFriendMap[j] = true
            }
        }
    }

    // user의 친구가 아닌 사람 중에서 타임라인을 방문한 친구에게 +1
    for (i in visitors) {
        if (userFriendMap[i] == null) addScore(i, 1)
    }

    // 사용자와 함꼐 아는 친구 +10
    for (i in friends) {
        if (i[0] != user && i[1] != user) {
            if (userFriendMap[i[0]] == true)  addScore(i[1], 10)
            if (userFriendMap[i[1]] == true)  addScore(i[0], 10)
        }
    }

    val answer = mutableListOf<String>()
    // 추천 점수 내림차순, 이름 오름차순
    friendScoreMap = friendScoreMap.toList().sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first }).toMap() as HashMap<String, Int>
    for ( (name, score) in friendScoreMap){
        // 친구 추천이기 때문에, 이미 친구는 추천목록에서 제외,  0점인 경우 제외
        if (userFriendMap[name] == null && score != 0){
            // 최대 5명
            if (answer.size < 5) answer.add(name)
            else break
        }
    }
    return answer
}

// 점수 추가 함수
fun addScore(name: String, score: Int) {
    if (friendScoreMap[name] == null) friendScoreMap[name] = score
    else {
        val n = friendScoreMap[name]
        if (n != null) friendScoreMap[name] = n + score
    }
}