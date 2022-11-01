package onboarding
fun findUserFriends(userFriend : MutableList<String>, friends: List<List<String>>, user: String): MutableList<String>{
    var cnt : Int = 0
    for(i in 0..friends.size-1){
        if(user == friends[i][0]){
            userFriend.add(cnt,friends[i][1])
            cnt += 1
        } else if(user == friends[i][1]){
            userFriend.add(cnt,friends[i][0])
            cnt += 1
        }
    }
    return userFriend
}
fun mutualFriends(userFriend : MutableList<String>, friends: List<List<String>>, ten: HashMap<String, Int>): HashMap<String, Int>{
    for(i in 0..userFriend.size-1){//사용자와 함께 아는 친구의 수
        for(j in 0..friends.size-1){
            if(userFriend[i] == friends[j][0]){
                ten.put(friends[j][1], ten.get(friends[j][1])?.plus(1) ?: 1)

            } else if(userFriend[i] == friends[j][1]){
                ten.put(friends[j][1], ten.get(friends[j][1])?.plus(1) ?: 1)
            }
        }
    }
    return ten
}
fun visited(visitors: List<String>, one: HashMap<String, Int>): HashMap<String, Int>{
    for(i in 0..visitors.size-1){//사용자의 타임 라인에 방문한 횟수
        one.put(visitors[i], one.get(visitors[i])?.plus(1) ?: 1)
    }
    return one
}
fun calculateScore(user: String, userFriend: MutableList<String>, one: HashMap<String, Int>, ten: HashMap<String, Int>, score: HashMap<String, Int>): HashMap<String, Int>{
    //10점
    var keyList = ArrayList(ten.keys)
    var valueList = ArrayList(ten.values)
    for(i in 0..ten.size-1){
        if(ten.containsKey(user)){
            ten.remove(user)
        }
    }
    for(i in 0..ten.size-1){
        score.put(keyList[i],valueList[i]*10)
    }
    //1점
    keyList = ArrayList(one.keys)
    valueList = ArrayList(one.values)
    for(i in 0..one.size-1){
        if(score.containsKey(keyList[i])){
            score[keyList[i]] = valueList[i]+ten.getValue(keyList[i])*10
        } else {
            score.put(keyList[i],valueList[i])
        }
    }
    for(i in 0..userFriend.size-1){
        if(score.containsKey(userFriend[i])){
            score.remove(userFriend[i])
        }
    }
    return score
}
fun answer(score: HashMap<String, Int>, answer : MutableList<String>): List<String> {
    //결과
    var keyList = ArrayList(score.keys)
    var valueList = ArrayList(score.values)
    var sortedValue = valueList.sortedDescending()
    var save : MutableList<String> = mutableListOf()
    var sortedSave : List<String>
    var temp : Int = 0
    var saveTemp : Int = 0
    var quit : Int = 0
    var cnt : Int = 0
    val max : Int = 5
    if(valueList.distinct().size == 1){
        var sortedKeyList : List<String> = mutableListOf()
        sortedKeyList = keyList.sorted()
        for(i in 0..max-1){
            answer.add(i,sortedKeyList[i])
        }
        return keyList.sorted()
    } else if(valueList.distinct().size != score.size){
        //중복 이름순
        var j : Int = 0
        while(quit == 0){
            if(sortedValue[cnt] == valueList[j]){
                save.add(saveTemp,keyList[j])
                saveTemp += 1
                valueList[j] = -1
            } else if(save.isNotEmpty()){
                sortedSave = save.sorted()
                for(k in 0..sortedSave.size-1){
                    if(answer.size == max){
                        return answer
                    }
                    answer.add(temp,sortedSave[k])
                    temp += 1
                }
                cnt = save.size + cnt
                save = mutableListOf()
                saveTemp = 0
                j = 0
                if(answer.size == score.size){
                    quit = 1
                }else{
                    continue
                }
            }
            if(j == valueList.size-1){
                j = 0
            }else{
                j += 1
            }
        }
    } else if(valueList.distinct().size == score.size){
        //숫자순
        for(i in 0..score.size-1){
            for(j in 0..score.size-1){
                if(sortedValue[i] == valueList[j]){
                    if(answer.size == max){
                        continue
                    }
                    answer.add(i,keyList[j])
                }
            }
        }
    }
    return answer
}
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var userFriend : MutableList<String> = mutableListOf()
    var ten = HashMap<String, Int>()
    var one = HashMap<String, Int>()
    var score = HashMap<String, Int>()
    var answer : MutableList<String> = mutableListOf()
    userFriend = findUserFriends(userFriend, friends, user)//user친구 찾기
    ten = mutualFriends(userFriend, friends, ten)//사용자와 함께 아는 친구의 수
    one = visited(visitors,one)//사용자의 타임 라인에 방문한 횟수
    score = calculateScore(user, userFriend, one, ten, score)//점수 계산
    return answer(score, answer)//결과 계산
}