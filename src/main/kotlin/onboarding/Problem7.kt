package onboarding

data class RecommendationFriendInfo (
    val userName : String,
    var recommendScore : Int = 0,
    var friendList : MutableList<String> = mutableListOf<String>(),
)

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    var friendsList : List<RecommendationFriendInfo> = initFriendInfo(friends, visitors)

    friendsList = calculateScore(user, friendsList, visitors)

    var result : List<String> = recommendUserList(user, friendsList)


    return result
}

fun recommendUserList(user : String, friendsList: List<RecommendationFriendInfo>): List<String> {
    // val tmp_recommentList = friendsList.sortedByDescending { it.recommendScore }
    val tmp_recommentList = friendsList.sortedWith(compareBy({ -(it.recommendScore) }, { it.userName }))

    var recommentList : MutableList<String> = mutableListOf()

    for(i in tmp_recommentList.indices) {
        val friend = tmp_recommentList[i].userName
        val userIndex = findIndex(tmp_recommentList, user)

        if(friend == user) continue
        if(tmp_recommentList[userIndex].friendList.contains(friend)) continue

        recommentList.add(tmp_recommentList[i].userName)

    }

    return recommentList
}

fun calculateScore(user: String, friendsList: List<RecommendationFriendInfo>, visitors: List<String>): List<RecommendationFriendInfo> {

    val tmp_friendsList = friendsList

    for(i in tmp_friendsList.indices) {
        tmp_friendsList[i].recommendScore += visitors.count{ it == tmp_friendsList[i].userName }
    }

    val userIndex : Int = findIndex(friendsList, user)

    for(i in tmp_friendsList[userIndex].friendList.indices) {
        val userFriend : String = tmp_friendsList[userIndex].friendList[i]
        val friendIndex : Int = findIndex(tmp_friendsList, userFriend)

        if(user == userFriend) continue

        for(j in tmp_friendsList[friendIndex].friendList.indices) {
            val scoreAddFriend = tmp_friendsList[friendIndex].friendList[j]
            val scoreAddFriendIndex = findIndex(tmp_friendsList, scoreAddFriend)
            tmp_friendsList[scoreAddFriendIndex].recommendScore += 10
        }
    }

    return tmp_friendsList
}

fun initFriendInfo(
    friends: List<List<String>>,
    visitors: List<String>): List<RecommendationFriendInfo> {

    var friendList : MutableList<RecommendationFriendInfo> = mutableListOf()

    for(i in friends.indices) {
        if(friendList.find { it.userName == friends[i][0] } == null) {
            friendList.add(
                RecommendationFriendInfo(userName = friends[i][0], friendList = mutableListOf(friends[i][1]) )
            )
        }
        if(friendList.find { it.userName == friends[i][1] } == null) {
            friendList.add(
                RecommendationFriendInfo(userName = friends[i][1], friendList = mutableListOf(friends[i][0]) )
            )
        }
    }
    for(i in friends.indices) {
        if(friendList.find { it.userName == friends[i][0] } != null) {
            val insert_index = findIndex(friendList, friends[i][0])
            friendList[insert_index].friendList.add(friends[i][1])
        }
        if(friendList.find { it.userName == friends[i][1] } != null) {
            val insert_index = findIndex(friendList, friends[i][1])
            friendList[insert_index].friendList.add(friends[i][0])
        }
    }
    for(i in visitors.indices) {
        if(friendList.find { it.userName == visitors[i] } == null) {
            friendList.add(
                RecommendationFriendInfo(userName = visitors[i], friendList = mutableListOf() )
            )
        }
    }
    for(i in friendList.indices) {
        friendList[i].friendList = friendList[i].friendList.distinct().toMutableList()
    }

    return friendList
}

fun findIndex(friendList: List<RecommendationFriendInfo>, findFriendName: String): Int {
    var result = -1
    if(friendList.find { it.userName == findFriendName } != null) {
        for(i in friendList.indices) {
            if(friendList[i].userName == findFriendName) return i
        }
    }

    return result
}
