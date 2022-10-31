package onboarding

import java.lang.Integer.min

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val recommendFriend = mutableMapOf<String, Int>()
    val userFriends = getUserFriend(user, friends)

    for (friend in friends) {
        // add score: (user's common friend)*10
        for (name in friend) {
            if (isValidFriend(user, name, userFriends))
                recommendFriend[name] = commonFriendCount(name, friends) * 10
        }
    }

    for (visitor in visitors) {
        // if visitor is valid and over 0
        // add score: (count of visit)*1
        val visitedCount = visitors.count { it == visitor && isValidFriend(user, it, userFriends) }
        if (visitedCount > 0) recommendFriend[visitor] = visitedCount
    }

    return recommendFriend.toList()
        .sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })
        .toMap().keys
        .toList()
        .slice(0..min(4, recommendFriend.size - 1))
}

// check if friend is user or his friend.
fun isValidFriend(user: String, name: String, userFriend: List<String>) : Boolean{
    val isFriend = userFriend.contains(name)
    val isSelf = (user == name)
    return (!isFriend && !isSelf)
}

// get user's friend list
fun getUserFriend(user: String, friends: List<List<String>>) : List<String>{
    val friendList = mutableListOf<String>()
    for (friend in friends){
        if (user == friend[1]) friendList.add(friend[0]) // add user's friend
        if (user == friend[0]) friendList.add(friend[1]) // add user's friend
    }
    return friendList
}

// get user's common friend's size
fun commonFriendCount(name: String, friends: List<List<String>>): Int{
    var count = 0
    for (friend in friends){
        if (name == friend[1] || name == friend[0]) // if common
            count ++
    }
    return count
}
