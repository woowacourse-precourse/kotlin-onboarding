package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var hash_map_score = HashMap<String,Int>()
    var hash_map_friends = HashMap<String,String>()
    var _delimiter: String = ";"
    //친구 네트워크 생성(그래프)
    friends.forEach{
        if(hash_map_friends[it[0]].isNullOrEmpty()){
            hash_map_friends[it[0]]=it[1]
        }
        else hash_map_friends[it[0]] += _delimiter+it[1]
        //양방향
        if(hash_map_friends[it[1]].isNullOrEmpty()){
            hash_map_friends[it[1]]=it[0]
        }
        else hash_map_friends[it[1]] += _delimiter+it[0]
    }

    //점수 계산
    val friends_of_user: List<String> = hash_map_friends.getValue(user).split(_delimiter)
    //친구의 친구리스트
    friends_of_user.forEach {
        for(friend in hash_map_friends.getValue(it).split(_delimiter)){
            if(!(friend in friends_of_user||friend == user)){ //이미 친구거나 자신이 아닐 때
                if(hash_map_score.containsKey(friend)){
                    hash_map_score.replace(friend,hash_map_score[friend]!!+10)
                }else{
                    hash_map_score.put(friend,10)
                }
            }
        }

    }
    //방문자 점수 계산
    visitors.forEach{
        if(!(it in friends_of_user || it == user)){
            if(hash_map_score.containsKey(it)){
                hash_map_score.replace(it,hash_map_score[it]!!+1)
            }else{
                hash_map_score.put(it,1)
            }
        }
    }
    //정렬 우선순위 1. 점수 2. 이메일순
    hash_map_score= hash_map_score.toList().sortedBy { it.first }.toMap() as HashMap<String, Int>
    hash_map_score= hash_map_score.toList().sortedByDescending { it.second }.toMap() as HashMap<String, Int>
    return hash_map_score.keys.toList()
}