package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val usersFriendsList = getMyFriendsList(user, friends)
    val recommendedFriendsSet = getRecommendedFriends(user, friends, usersFriendsList, visitors)

    return recommendedFriendsSet.toList().sortedWith(
        compareByDescending<Pair<String, Int>> { it.second }
            .thenBy { it.first }
    ).toMap().keys.toList()
}

fun getRecommendedFriends(
    user: String,
    friends: List<List<String>>,
    myFriends: HashSet<String>,
    visitors: List<String>
): HashMap<String, Int> {
    var recommendedFriendsMap = hashMapOf<String, Int>()

    for(friend in friends) {
        if(friend[0] == user || friend[1] == user) {
            continue
        }

        val commonFriend = when {
            myFriends.contains(friend[0]) -> { friend[1] }
            myFriends.contains(friend[1]) -> { friend[0] }
            else -> { continue }
        }
        recommendedFriendsMap[commonFriend] = recommendedFriendsMap.getOrDefault(commonFriend, 0) + 10
    }

    for(visitor in visitors) {
        if(visitor == user || myFriends.contains(visitor)) {
            continue
        }

        recommendedFriendsMap[visitor] = recommendedFriendsMap.getOrDefault(visitor, 0) + 1
    }

    return recommendedFriendsMap
}

fun getMyFriendsList(
    user: String,
    friends: List<List<String>>
): HashSet<String> {
    var myFriendsSet = hashSetOf<String>()

    for(friend in friends) {
        when (user) {
            friend[0] -> myFriendsSet.add(friend[1])
            friend[1] -> myFriendsSet.add(friend[0])
        }
    }

    return myFriendsSet
}
