package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var userFriendsList = findUserFriends(user, friends)// user와 친구인 이름 목록
    var friendsFriendsList = findFriendsFriends(user, userFriendsList, friends) // user의 친구들과 친구인 이름 목록
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
            continue
        }
    }
    return userFriendsList
}

/* user의 친구와 친구인 이름을 찾는 메소드 */
fun findFriendsFriends(user: String, userFriendsList: ArrayList<String>, friends: List<List<String>>): ArrayList<MutableMap<String, Int>> {
    var friendsFriendsList = arrayListOf<MutableMap<String, Int>>()
    var person = mutableMapOf<String, Int>()

    for(name in userFriendsList){
        for(i in friends.indices){
            if(friends[i][0] == name && friends[i][1] != user){
                person[friends[i][1]] = 0
                friendsFriendsList.add(person)
                continue
            }
            if(friends[i][1] == name && friends[i][0] != user){
                person[friends[i][1]] = 0
                friendsFriendsList.add(person)
            }
        }
    }
    return friendsFriendsList
}



