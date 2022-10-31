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
        if (isValidFriend(user, friend[0], userFriends))
            recommendFriend[friend[0]] = commonFriendCount(friend[0], friends) * 10

        if (isValidFriend(user, friend[1], userFriends))
            recommendFriend[friend[1]] = commonFriendCount(friend[1], friends) * 10
    }

    for (visitor in visitors) {
        val visitedCount = visitors.count { it == visitor && isValidFriend(user, it, userFriends) }
        if (visitedCount > 0) recommendFriend[visitor] = visitedCount
    }

    val result = recommendFriend.toList()
            .sortedWith(compareByDescending<Pair<String, Int>> {it.second}
            .thenBy { it.first })
            .toMap().keys
            .toList()
            .slice(0..min(4, recommendFriend.size-1))

    return result
}

fun isValidFriend(user: String, name: String, userFriend: List<String>) : Boolean{
    val isFriend = userFriend.contains(name)
    val isSelf = (user == name)
    return (!isFriend && !isSelf)
}

fun getUserFriend(user: String, friends: List<List<String>>) : List<String>{
    val friendList = mutableListOf<String>()
    for (friend in friends){
        if (user == friend[1]) friendList.add(friend[0])
        if (user == friend[0]) friendList.add(friend[1])
    }
    return friendList
}

fun commonFriendCount(name: String, friends: List<List<String>>): Int{
    var count = 0
    for (friend in friends){
        if (name == friend[1] || name == friend[0])
            count ++
    }
    return count
}
