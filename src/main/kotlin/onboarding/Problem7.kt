package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val map_score = mutableMapOf<String, Int>() // 점수 맵
    val list_fr = mutableListOf<String>()       // user의 친구 리스트
    val list_ff = mutableListOf<String>()       // 친구의 친구 리스트 중복 가능
    val list_vs = mutableListOf<String>()       // 방문자 리스트 중복 가능
    val list_reco_fri = mutableListOf<String>() // 추천 친구 리스트
    val answer = mutableListOf<String>()        // 정답 리스트
    var k = 0
    var score = 0
    for(i in friends.indices){      // 1) user의 친구를 찾아내는 단계
        if(friends[i].indexOf(user) != -1){     // user를 포함한 친구관계
            k = 1 - friends[i].indexOf(user)    // user의 직접적인 친구 -> user 0 : 1, user 1 : 0
            list_fr.add(friends[i][k])          // user의 직접적인 친구 추가
        }
    }
    for(fri in list_fr){      // 2) user의 친구의 친구를 찾아내는 단계 중복허용
        for(i in friends.indices){
            if(friends[i].indexOf(fri) != -1){   // 친구를 포함한 친구관계
                k = 1 - friends[i].indexOf(fri)  // 친구의 친구 -> user 0 : 1, user 1 : 0
                list_ff.add(friends[i][k])       // 친구의 친구 추가
            }
            list_ff.remove(user)        // user는 리스트에서 제거
        }
    }
    for(vst in visitors){       // 3) user의 타임라인에 방문한 사람 (친구는 제외) 단, 방문이므로 user는 없다고 고려
        if(vst !in list_fr){
            list_vs.add(vst)    // user의 직접적인 친구가 아닌경우 추가
        }
    }

    val list_ff_cp = list_ff.distinct()     // 친구의 친구 중복 불가
    val list_vs_cp = list_vs.distinct()     // 타임라인 방문자 중복 불가

    list_reco_fri.addAll(list_ff_cp)    // 추천 친구 리스트에 친구의 친구 추가
    list_reco_fri.addAll(list_vs_cp)    // 추천 친구 리스트에 방문자 추가
    list_reco_fri.sort()    // 추천 친구 리스트 이름순으로 먼저 정렬

    for (element in list_reco_fri){
        score = 10 * list_ff.count{it == element} + 1 * list_vs.count{it == element}    // 점수 로직
        map_score.put(element, score)   // 친구 이름 : 점수

    }
    // 내림차순 정렬 -> toList로 리스트 변경 후 sortedBy함수를 사용하여 두번째 기준점을 이용하여 정렬후 다시 맵으로 변경
    val map_final = map_score.toList().sortedByDescending { it.second }.toMap() as MutableMap
    for(element in map_final.keys){
        answer.add(element)
    }
    return answer
}
