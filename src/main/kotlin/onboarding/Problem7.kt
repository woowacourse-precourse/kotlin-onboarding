package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val userFriendsList = getUserFriendsList(user, friends)
    val mutualFriendsList = getMutualFriendsList(friends, userFriendsList)
    val friendsMapWithMutual = calculateFriendsPoint(mutualFriendsList)
    val friendsListWithVisit = calculateVisitPoint(friendsMapWithMutual, visitors)
    var result: List<String>

    if (friendsListWithVisit.contains(user)) {
        friendsListWithVisit.remove(user)
    }

    result = friendsListWithVisit

    if(result.size>4){
        result = result.subList(0,4)
    }

    return result
}

private fun getUserFriendsList(userId: String, friends: List<List<String>>): MutableList<String> {
    val userFriendsList: MutableList<String> = mutableListOf()

    for (i in friends.indices) {
        if (friends[i][0] == userId) {
            userFriendsList.add(friends[i][1])
        } else if (friends[i][1] == userId) {
            userFriendsList.add(friends[i][0])
        }
    }
    return userFriendsList
}

private fun getMutualFriendsList(
    friends: List<List<String>>,
    userFriendsList: MutableList<String>
): MutableList<String> {
    val mutualFriendsList: MutableList<String> = mutableListOf()

    for (i in friends.indices) {
        if (userFriendsList.contains(friends[i][0])) {
            mutualFriendsList.add(friends[i][1])
        } else if (userFriendsList.contains(friends[i][1])) {
            mutualFriendsList.add(friends[i][0])
        }
    }
    return mutualFriendsList
}

private fun calculateFriendsPoint(
    mutualFriendsList: MutableList<String>
): MutableMap<String, Int> {
    val friendsMapWithMutual: MutableMap<String, Int> = mutableMapOf()

    for (i in mutualFriendsList.indices) {
        if (friendsMapWithMutual.contains(mutualFriendsList[i])) {
            friendsMapWithMutual[mutualFriendsList[i]] =
                friendsMapWithMutual.getValue(mutualFriendsList[i]) + 10
        } else {
            friendsMapWithMutual[mutualFriendsList[i]] = 0
        }
    }
    return friendsMapWithMutual
}

private fun calculateVisitPoint(
    friendsMapWithMutual: MutableMap<String, Int>,
    visitors: List<String>
): MutableList<String> {
    val friendsListWithVisit: MutableList<String> = mutableListOf()
    for (i in visitors.indices) {
        if (friendsMapWithMutual.contains(visitors[i])) {
            friendsMapWithMutual[visitors[i]] = friendsMapWithMutual.getValue(visitors[i]) + 1
        } else {
            friendsMapWithMutual[visitors[i]] = 0
        }
    }

    for(element in friendsMapWithMutual){
        if(element.value != 0){
            friendsListWithVisit.add(element.key)
        }
    }
    return friendsListWithVisit
}