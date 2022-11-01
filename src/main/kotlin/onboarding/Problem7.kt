package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    /*
    var userFriendsList // user와 친구인 이름 목록
    var friendsFriendsList // user의 친구들과 친구인 이름 목록
     */
}

/* user와 친구인 이름을 찾는 메소드 */
fun findUserFriends(user: String, friends: List<List<String>>): ArrayList<String> {
    var userFriendsList = arrayListOf<String>()
    for(i in friends.indices){
        if(friends[i][0] == user){
            userFriendsList.add(friends[i][1])
            continue
        }
        if(friends[i][1] == user){
            userFriendsList.add(friends[i][0])
        }
    }
    return userFriendsList
}
