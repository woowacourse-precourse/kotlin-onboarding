package onboarding

import java.lang.Math.abs

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendList : ArrayList<String> = arrayListOf()
    userFriendExtract(user, friends, userFriendList)
    var friendsWithScore : HashMap<String, Int> = hashMapOf()
    
    friendsWithIntersects(user,userFriendList,friends, friendsWithScore)
    friendsWithScore = friendsWith1Points(visitors, userFriendList, friendsWithScore)

    var friendsWithScoreList = friendsWithScore.toList()
        .sortedWith(compareBy({-it.second}, {it.first}))
        .toMap()
        .keys
        .toList()

    if(friendsWithScoreList.size > 5){
        friendsWithScoreList = friendsWithScoreList.slice(0..4)
        return friendsWithScoreList
    }
    return friendsWithScoreList
}

fun userFriendExtract(user: String, friends: List<List<String>>,userFriendList: ArrayList<String> ){
    for ((i, _) in friends.withIndex()) {
        userFriendFind(friends[i], user, userFriendList)
    }
}

fun userFriendFind(friends: List<String>, user:String, userFriendList: ArrayList<String>){
    if (friends.contains(user)){
        if (friends.indexOf(user) == 1) {
            userFriendList.add(friends[0])
        }
        if (friends.indexOf(user) == 0){
            userFriendList.add(friends[1])
        }
    }
}

fun friendsWithIntersects(user : String,
                          userFriends : ArrayList<String>,
                          friends:List<List<String>>,
                          friendsWithScore: HashMap<String, Int>): HashMap<String, Int>{
    for ((i,_) in friends.withIndex()) {
        friendIsUsers(friends[i], userFriends, user, friendsWithScore)
    }
    return friendsWithScore
}

fun friendIsUsers(friends:List<String>,
                   userFriendsList:ArrayList<String>,
                   user:String,
                   friendsWithScore: HashMap<String, Int>){
    for (i in 0..friends.size-1) {
        if (userFriendsList.contains(friends[i])) {
            val friend = friends[abs(i - 1)]
            friendsWith10Points(friend, user, friendsWithScore)
        }
    }
}

fun friendsWith10Points(friend:String,
                        user:String,
                        friendsWithScore: HashMap<String, Int>){
    if (friend != user) {
        if (friendsWithScore.containsKey(friend)) {
            val score = friendsWithScore[friend]?.plus(10) ?: 0
            friendsWithScore[friend]?.plus(score)
        }
        if (!friendsWithScore.containsKey(friend)) {
            friendsWithScore.put(friend, 10)
        }
    }
}

fun friendsWith1Points(visitors: List<String>,
                       userFriendList: ArrayList<String>,
                       friendsWithScore : HashMap<String, Int>): HashMap<String, Int>{

    for (visitor in visitors) {
        if(userFriendList.contains(visitor)) {
            continue
        }
        if (friendsWithScore.containsKey(visitor)) {
            friendsWithScore[visitor] = friendsWithScore[visitor]?.plus(1) ?:0
        }
        if (!friendsWithScore.containsKey(visitor)){
            friendsWithScore.put(visitor, 1)
        }
    }
    return friendsWithScore
}

