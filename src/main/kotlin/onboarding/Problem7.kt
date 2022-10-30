package onboarding

import java.lang.Math.abs

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendList : ArrayList<String> = userFriendExtract(user,friends)
    var friendsWithScore : HashMap<String, Int>

    friendsWithScore = friendsWith10Points(user,userFriendList,friends)


    friendsWithScore = friendsWith3Points(visitors, userFriendList, friendsWithScore)

    var friendsWithScoreList = friendsWithScore.toList()
        .sortedWith(compareBy({-it.second}, {it.first}))
        .toMap()
        .keys
        .toList()

    if(friendsWithScoreList.size > 5){
        friendsWithScoreList = friendsWithScoreList.slice(0..4)
        return friendsWithScoreList

    }else{

        return friendsWithScoreList
    }
}

fun userFriendExtract(user: String, friends: List<List<String>>): ArrayList<String>{
    val userFriendList = ArrayList<String>()

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
                        }
                    } else {
                        friendsWithScore.put(friends[i][abs(j - 1)], 10)
                    }
                }
            }
        }
    }
    return friendsWithScore
}

fun friendsWith3Points(visitors: List<String>,userFriendList: ArrayList<String>,friendsWithScore : HashMap<String, Int>): HashMap<String, Int>{
    val friendsWithScoreUpdate = friendsWithScore

    for (visitor in visitors) {

        if(userFriendList.contains(visitor)) {
            continue
        }
        if (friendsWithScore.containsKey(visitor)) {
            val score = friendsWithScore.get(visitor)?.plus(3)
            if (score != null) {
                friendsWithScore[visitor] = score
            }
        } else {
            friendsWithScore.put(visitor, 3)
        }
    }
    return friendsWithScoreUpdate
}

