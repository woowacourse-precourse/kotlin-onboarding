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

//함께아는 사람 점수 계산
fun countFriendScore(
    user: String,
    usersFriend: List<String>,
    friends: List<List<String>>,
    result: HashMap<String, Int>
) {
    for (i in usersFriend) {
        for (j in friends) {
            if (j.contains(i) && !j.contains(user)) {
                if (j.indexOf(i) == 0) {
                    if (result.containsKey(j[1])) {
                        result[j[1]] = result[j[1]]!! + 10
                    } else {
                        result[j[1]] = 10
                    }
                } else {
                    if (result.containsKey(j[0])) {
                        result[j[0]] = result[j[0]]!! + 10
                    } else {
                        result[j[0]] = 10
                    }
                }
            }
        }
    }

}

//방문한 사람 점수 계산
fun countVisitScore(visitors: List<String>, result: HashMap<String, Int>, usersFriend: List<String>) {
    for (i in visitors) {
        if (!usersFriend.contains(i)) {
            if (result.containsKey(i)) {
                result[i] = result[i]!! + 1
            } else {
                result[i] = 1
            }
        }
    }
}

//score 정렬하기
fun sortScore(result: HashMap<String, Int>): HashMap<String, Int> {
    return result.toList().sortedWith(
        compareBy(
            { -(it.second) }, { it.first }
        )
    ).toMap() as HashMap
}