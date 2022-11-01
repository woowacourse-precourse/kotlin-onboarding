package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val user = user
    val friends = friends
    val visitors = visitors
    var friendsOfUser = ArrayList<String>()
    var indexArray = ArrayList<Int>()
}

/**
유저와 친구인 사람의 이름과 전달받은 배열에서의 index를 저장하는 기능
 */
fun findFriendsOfUser(user: String, friends: List<List<String>>, friendsOfUser: ArrayList<String>, indexArray: ArrayList<Int>){
    for (index in friends.indices){
        if (friends[index].indexOf(user) != -1){
            friendsOfUser.add(friends[index][1 - friends[index].indexOf(user)])
            indexArray.add(index)
        }
    }
}
