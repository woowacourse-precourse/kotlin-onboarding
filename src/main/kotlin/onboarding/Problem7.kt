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
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var userFriend : MutableList<String> = mutableListOf()
    var ten = HashMap<String, Int>()
    var one = HashMap<String, Int>()
    var score = HashMap<String, Int>()
    userFriend = findUserFriends(userFriend, friends, user)//user친구 찾기
    ten = mutualFriends(userFriend, friends, ten)//사용자와 함께 아는 친구의 수
    one = visited(visitors,one)//사용자의 타임 라인에 방문한 횟수
    score = calculateScore(user, userFriend, one, ten, score)//점수 계산
    TODO("프로그램 구현")
}