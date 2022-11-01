package onboarding

fun solution7( user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    var hashMapScores = HashMap<String,Int>()
    val hashMapFriends = HashMap<String,String>()
    val splitter: String = ","

    // 1. 우선 서로 친구인지 확인하는 상호 친구 네트워크를 위한 리스트 형성
    for(namesOfFriends in friends){
        if(hashMapFriends[namesOfFriends[0]].isNullOrEmpty()){
            hashMapFriends[namesOfFriends[0]]=namesOfFriends[1]
        }
        else hashMapFriends[namesOfFriends[0]] += splitter+namesOfFriends[1]

        if(hashMapFriends[namesOfFriends[1]].isNullOrEmpty()){
            hashMapFriends[namesOfFriends[1]]=namesOfFriends[0]
        }
        else hashMapFriends[namesOfFriends[1]] += splitter+namesOfFriends[0]
    }

    // 2. 두번 돌면서 나랑 겹치는 친구의 경우 +10을 위한 작업 진행
    val friendsOfUsers: List<String> = hashMapFriends.getValue(user).split(splitter)
    for (name in friendsOfUsers){
        for(friend in hashMapFriends.getValue(name).split(splitter)){
            if(!(friend in friendsOfUsers||friend == user)){
                if(hashMapScores.containsKey(friend)){
                    hashMapScores.replace(friend,hashMapScores[friend]!!+10)
                }else{
                    hashMapScores[friend] = 10
                }
            }
        }
    }

    // 3. 단순 방문의 경우 +1 점 추가를 위한 진행.
    for(name in visitors) {
        if(!(name in friendsOfUsers || name == user)){
            if(hashMapScores.containsKey(name)){
                hashMapScores.replace(name,hashMapScores[name]!!+1)
            }else{
                hashMapScores[name] = 1
            }
        }
    }

    // 4. 차순에 맞게 sort 진행
    hashMapScores= hashMapScores.toList().sortedBy { it.first }.toMap() as HashMap<String, Int>
    hashMapScores= hashMapScores.toList().sortedByDescending { it.second }.toMap() as HashMap<String, Int>
    val result = hashMapScores.keys.toList()
    return result

}