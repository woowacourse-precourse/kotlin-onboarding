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
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var userFriend : MutableList<String> = mutableListOf()
    var ten = HashMap<String, Int>()
    userFriend = findUserFriends(userFriend, friends, user)//user친구 찾기
    ten = mutualFriends(userFriend, friends, ten)//사용자와 함께 아는 친구의 수
    TODO("프로그램 구현")
}