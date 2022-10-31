package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val recommendFriendMap = getRecommendFriendList(user, friends, visitors)
    return getRecommendFriendListName(recommendFriendMap)
}

fun checkUserFriend(relationship: List<String>, userName: String): String? {
    if (relationship[0] == userName && relationship[1] == userName) return null

    return when (userName) {
        relationship[0] -> relationship[1]
        relationship[1] -> relationship[0]
        else -> null
    }
}

fun getUserFriends(name: String, allFriendsList: List<List<String>>): Set<String> {
    val userFriends = mutableSetOf<String>()
    for (relationship in allFriendsList) {
        checkUserFriend(relationship, name)?.let { friendName -> userFriends.add(friendName) }
    }
    return userFriends
}

fun getOverFriends(name: String, allFriendsList: List<List<String>>, myFriendList: Set<String>): Set<String> {
    val overFriends = mutableSetOf<String>()
    for (friendName in myFriendList) {
        overFriends.addAll(getUserFriends(friendName, allFriendsList))
    }
    overFriends.remove(name)
    return overFriends.subtract(myFriendList)
}

fun addScoreOverFriend(recommendFriendMap: MutableMap<String, Int>, overFriends: Set<String>) {
    for (friend in overFriends) {
        recommendFriendMap[friend] = 10
    }
}

fun addScoreVisitor(recommendFriendMap: MutableMap<String, Int>, visitors: List<String>, userFriends: Set<String>) {
    val notFriendVisitors = ArrayList<String>(visitors)
    notFriendVisitors.removeAll(userFriends)

    for (visitor in notFriendVisitors) {
        recommendFriendMap[visitor] = recommendFriendMap.getOrPut(visitor) { 0 } + 1
    }
}

fun getRecommendFriendList(user: String, friends: List<List<String>>, visitors: List<String>): MutableMap<String, Int> {
    val recommendFriendMap: MutableMap<String, Int> = mutableMapOf()
    val userFriends: Set<String> = getUserFriends(user, friends)
    val overFriendsList: Set<String> = getOverFriends(user, friends, userFriends)

    addScoreOverFriend(recommendFriendMap, overFriendsList)
    addScoreVisitor(recommendFriendMap, visitors, userFriends)

    return recommendFriendMap
}

fun getRecommendFriendListName(recommendFriendMap: MutableMap<String, Int>): List<String> {
    val recommendFriendList = recommendFriendMap.toList()
    val results = recommendFriendList.sortedWith(compareBy({ -it.second }, { it.first }))

    val resultNames = mutableListOf<String>()
    for (result in results)
        resultNames.add(result.first)

    return resultNames
}