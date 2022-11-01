package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun getRecommendFriends(
    user: String,
    friends: List<List<String>>,
    myFriends: HashSet<String>,
    visitors: List<String>
): HashMap<String, Int> {
    var recommendFriendsMap = hashMapOf<String, Int>()

    for(friend in friends) {
        if(friend[0] == user || friend[1] == user) {
            continue
        }

        val commonFriend = when {
            myFriends.contains(friend[0]) -> { friend[1] }
            myFriends.contains(friend[1]) -> { friend[0] }
            else -> { continue }
        }
        recommendFriendsMap[commonFriend] = recommendFriendsMap.getOrDefault(commonFriend, 0) + 10
    }

    for(visitor in visitors) {
        if(visitor == user || myFriends.contains(visitor)) {
            continue
        }

        recommendFriendsMap[visitor] = recommendFriendsMap.getOrDefault(visitor, 0) + 1
    }

    return recommendFriendsMap
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
