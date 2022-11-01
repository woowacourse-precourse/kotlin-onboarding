package onboarding

fun solution7(user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    var userFriends = mutableSetOf<String>()
    var recommend = mutableMapOf<String, Int>()

    //사용자와 친구 관계를 맺고 있는 친구 리스트 만들기
    for (i in friends){
        if (i.contains(user)){
            for (j in (0..1)){
                userFriends.add(i[j])
            }
        }
    }
    userFriends.remove(user)

    //사용자와 함께 아는 친구인 경우 10점 추가
    for (i in friends){
        for (j in userFriends){
            //친구 리스트에 있는 친구의 친구 찾기
            if (i.contains(j)){
                for (k in (0..1)){
                    //만약 원래 친구 추천 리스트에 있다면
                    if (recommend.contains(i[k])){
                        var score = recommend.get(i[k])
                        if (score != null) {
                            recommend.put(i[k],score + 10)
                        }
                    }
                    if (!recommend.contains(i[k])){
                        recommend.put(i[k], 10)
                    }
                }
            }
        }
    }
    recommend.remove(user)

    //사용자의 타임 라인에 방문한 사람에겐 1점 추가
    for (i in visitors){
        //만약 원래 친구 추천 리스트에 있다면
        if (recommend.contains(i)){
            var score = recommend[i]
            if (score != null) {
                recommend.put(i,score + 1)
            }
        }
        if (!recommend.contains(i)){
            recommend.put(i, 1 )
        }
    }

    //사용자와 이미 친구인 사람은 친구 추천 알고리즘에서 제외
    for (i in userFriends){
        recommend.remove(i)
    }

    //점수가 큰 순서대로 정렬(같을 경우 이름순으로 정렬)
    recommend.remove(user)
    var recSort = recommend.toList().toMutableList()
    recSort.sortWith(compareBy({-it.second}, {it.first}))
    var recSortMap = recSort.toMap()
    var recList = recSortMap.keys.toList()


}
