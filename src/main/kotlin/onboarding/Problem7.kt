package onboarding

/**
 * 기능목록
 * (1) user 의 친구 목록 확인
 * (2) friends 목록에서 user 친구와 친구를 맺고있는 사람에게 10 점 부여
 * (3) user 타임 라인 방문했던 visitor 에게 1점 부여
 * (4) 점수 목록에서 (기능1)에서 확인한 친구들은 제외
 * (5) 점수 목록 이름 순 정렬 후 점수 순 정렬
 * (6) 점수가 가장 높은 순으로 최대 5명 선정
 * **/
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriends = mutableListOf<String>()
    val recommendScore = mutableMapOf<String, Int>() //사용자 점수 목록

    for(index in friends.indices){
        if(friends[index][1]==user){ //user 의 친구
            userFriends.add(friends[index][0])
        }
    }

    for(index in friends.indices){
        val friendA=friends[index][0]
        val friendB=friends[index][1]
        if(userFriends.contains(friendA) && (friendB != user)){ //friendA 가 user 의 친구인 경우
            if(recommendScore.containsKey(friendB)){
                val price = recommendScore[friendB]
                recommendScore[friendB] = (price?:0) + 10
                continue
            }
            recommendScore[friendB] = 10
        }
    }

    return listOf()
}
