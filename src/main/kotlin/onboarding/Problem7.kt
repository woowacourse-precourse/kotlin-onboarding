package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var answer = mutableListOf<String>()

    var userHashMap = HashMap<String, HashMap<String, String>>() // <이름, 친구관계> 저장
    var scoreHashMap = HashMap<String, Int>()               // <이름, 점수> 저장

    for (relation in friends){  // 친구 관계 정리
        var userName = userHashMap.get(relation[0])
        scoreHashMap.put(relation[0], 0)
        scoreHashMap.put(relation[1], 0)

        if(userName == null){   // 이름이 해시맵에 없는 경우
            val hashMap = HashMap<String, String>()
            hashMap.put(relation[1], relation[1])
            userHashMap.put(relation[0], hashMap)
        }
        else{   // 이름이 해시맵에 있는 경우
            userName.put(relation[1], relation[1])
        }

        userName = userHashMap.get(relation[1])

        if(userName == null){   // 이름이 해시맵에 없는 경우
            val hashMap = HashMap<String, String>()
            hashMap.put(relation[0], relation[0])
            userHashMap.put(relation[1], hashMap)

        }
        else{   // 이름이 해시맵에 있는 경우
            userName.put(relation[0], relation[0])
        }
    }

    scoreHashMap.remove(user)   // 사용자의 점수 삭제

    val userFriend : HashMap<String, String>? = userHashMap.get(user)
    if(userFriend != null){     // 사용자가 친구가 없는 경우 제외
        for(friend in userFriend){  // 사용자의 친구들의 친구에게 + 10점
            val friendName = friend.key

            val friendsOfFriend = userHashMap.get(friendName)!!

            for(friendOfFriend in friendsOfFriend){
                if(friendOfFriend.key != user){     // 사용자 외 사람만 점수 체크
                    val score = scoreHashMap.get(friendOfFriend.key)!!
                    scoreHashMap.set(friendOfFriend.key, score + 10)
                }
            }
        }
    }


    // 방문자들 점수 +1
    for(visitor in visitors){
        var score = scoreHashMap.get(visitor)
        
        if(score == null){  // 친구 관계에 없다면 새로 추가
            scoreHashMap.set(visitor, 1)
        }
        else{
            scoreHashMap.set(visitor, score + 1)
        }
    }

    // 최대 5명 추출
    // 1) 이미 친구인 경우 제외
    if(userFriend != null){     // 사용자가 친구가 없는 경우 제외
        for(friend in userFriend) {
            scoreHashMap.remove(friend.key)
        }
    }

    // 점수 기준으로 내림차순 정렬
    scoreHashMap = scoreHashMap.toList().sortedBy { it.first }.toMap() as HashMap
    scoreHashMap = scoreHashMap.toList().sortedByDescending { it.second }.toMap() as HashMap
    var cnt = 0
    var keys = scoreHashMap.keys

    while(!keys.isEmpty()){ // 선택할 키가 없을 시 종료
        if(cnt == 5){       // 5개 선택 완료시 종료
            break
        }

        if(scoreHashMap.get(keys.first()) != 0){    // value가 0이 아닌 경우에만 추가
            answer.add(keys.first())
            cnt++
        }
        keys.remove(keys.first())
    }

    return answer
}