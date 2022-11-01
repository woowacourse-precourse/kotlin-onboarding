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
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var userFriend : MutableList<String> = mutableListOf()
    userFriend = findUserFriends(userFriend, friends, user)//user친구 찾기
    TODO("프로그램 구현")
}