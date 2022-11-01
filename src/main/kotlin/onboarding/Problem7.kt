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

    for(index in visitors.indices){ //user 타임라인 방문자 +1점
        val visitorName=visitors[index]
        if(recommendScore.containsKey(visitorName)){
            val price = recommendScore[visitorName]
            recommendScore[visitorName] = (price?:0) + 1
            continue
        }
        recommendScore[visitorName] = 1
    }

    for(index in userFriends.indices){
        recommendScore.remove(userFriends[index]) //이미 친구인 사람은 제외
    }

    val listSortedByName = recommendScore.toList().sortedBy { it.first }.toMap().toMutableMap()
    val listSortedByScore = listSortedByName.toList().sortedByDescending { it.second }

    val recommendedFriends = mutableListOf<String>() //추천친구 목록

    //점수가 가장 높은 순으로 최대 5명 선정
    for(index in 0..4){
        recommendedFriends.add(listSortedByScore[index].first)
        if(listSortedByScore.size-1 == index){ //추천 목록에 5명 이하 있는 경우
            break
        }
    }

    return recommendedFriends
}
