package onboarding

import java.lang.Math.abs

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendList : ArrayList<String> = userFriendExtract(user,friends)
    var friendsWithScore : HashMap<String, Int> = hashMapOf()



    return friendsWithScore.toList().sortedWith(compareBy({-it.second}, {it.first})).toMap().keys.toList()
}

fun userFriendExtract(user: String, friends: List<List<String>>): ArrayList<String>{
    val userFriendList = ArrayList<String>()
    //user의 친구목록 만들기
    for ((i, _) in friends.withIndex()) {
        if (friends[i].contains(user)) {
            if (friends[i].indexOf(user) == 1) {
                userFriendList.add(friends[i][0])
            } else {
                userFriendList.add(friends[i][1])
            }
        }
    }
    return userFriendList
}



