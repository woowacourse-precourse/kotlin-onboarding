package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val map_score = mutableMapOf<String, Int>()     // 점수 맵
    val list_fr = mutableListOf<String>()       // user의 친구
    val list_ff = mutableListOf<String>()       // 친구의 친구 중복 가능
    val list_ff_cp = mutableSetOf<String>()         // 친구의 친구 중복 불가
    val list_vs = mutableListOf<String>()
    var k = 0
    for(i in friends.indices){      // 1) user의 친구를 찾아내는 단계
        if(friends[i].indexOf(user) != -1){     // user를 포함한 친구관계
            k = 1 - friends[i].indexOf(user)     // user의 직접적인 친구 -> user 0 : 1, user 1 : 0
            list_fr.add(friends[i][k])          // user의 직접적인 친구 추가
        }
    }
    for(fri in list_fr){      // 2) user의 친구의 친구를 찾아내는 단계 중복허용
        for(i in friends.indices){
            if(friends[i].indexOf(fri) != -1){     // 친구를 포함한 친구관계
                k = 1 - friends[i].indexOf(fri)     // 친구의 친구 -> user 0 : 1, user 1 : 0
                list_ff.add(friends[i][k])          // 친구의 친구 추가
            }
            list_ff.remove(user)        // user는 리스트에서 제거
        }
    }

    list_ff_cp.addAll(list_ff)      // 깊은복사 대행
    list_ff_cp.distinct()           // 중복 제거
    println(list_ff_cp)
    return list_ff
}
