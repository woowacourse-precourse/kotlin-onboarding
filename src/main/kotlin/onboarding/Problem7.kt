package onboarding

import java.lang.Math.abs

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendList : ArrayList<String> = userFriendExtract(user,friends)
    val friendsWithScore : HashMap<String, Int>

    friendsWithScore = friendsWith10Points(user,userFriendList,friends)

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

fun friendsWith10Points(user : String, userFriends : ArrayList<String>, friends:List<List<String>>): HashMap<String, Int>{
    val friendsWithScore : HashMap<String, Int> = hashMapOf()

    for ((i, row) in friends.withIndex()) {
        for ((j, _) in row.withIndex()) {

            if (userFriends.contains(friends[i][j])) {
                if (friends[i][abs(j - 1)] != user) {
                    if (friendsWithScore.containsKey(friends[i][abs(j - 1)])) {
                        val score = friendsWithScore.get(friends[i][abs(j - 1)])?.plus(10)

                        if (score != null) {
                            friendsWithScore[friends[i][abs(j - 1)]] = score

                        } else {
                            friendsWithScore.put(friends[i][abs(j - 1)], 10)
                        }
                    }
                }
            }
        }
    }
    return friendsWithScore

}



