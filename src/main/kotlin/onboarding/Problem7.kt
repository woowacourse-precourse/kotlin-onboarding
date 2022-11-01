package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendOfFriendList = getFriendOfFriendList(user,friends)
    val friendsNameList = mutableListOf<String>()
    val visitorNamesList = mutableListOf<String>()
    val everyoneList = mutableSetOf<String>()
    var nameAndScore = mutableMapOf<String,Int>()
    for (i in friends) {
        if (i[1] != user) {
            friendsNameList.add(i[0])
            everyoneList.add(i[1])
        }
    }
    for (i in visitors) {
        if (i != user && friendsNameList.indexOf(i) == -1) {
            visitorNamesList.add(i)
            everyoneList.add(i)
        }
    }
    var friendOfFriendCountMap = friendOfFriendList.groupingBy {it}.eachCount()
    var visitorNamesCountMap = visitorNamesList.groupingBy {it}.eachCount()
    for(i in everyoneList) {
        if(friendOfFriendCountMap.containsKey(i)) { nameAndScore[i] = friendOfFriendCountMap[i]!!.times(10) }
    }
    for(i in visitorNamesCountMap.keys) {
        if(nameAndScore.containsKey(i)) nameAndScore[i]=nameAndScore[i]!!.plus(visitorNamesCountMap[i]!!)
        else nameAndScore[i] = visitorNamesCountMap[i]!!
    }
    nameAndScore = if(nameAndScore.size>5)  nameAndScore.toSortedMap().toList().sortedByDescending { it.second }.subList(0,5).toMap() as MutableMap
    else nameAndScore.toSortedMap().toList().sortedByDescending { it.second }.toMap() as MutableMap
    return nameAndScore.keys.toList()
}

private fun getFriendOfFriendList( user: String,friends: List<List<String>>):MutableList<String> {
    val friendOfFriendList = mutableListOf<String>()
    for (i in friends) {
        if (i[1] != user) {
            friendOfFriendList.add(i[1])
        }
    }
    return friendOfFriendList
}