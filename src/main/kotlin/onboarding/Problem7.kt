package onboarding

//- 사용자가 함께 아는 친구 목록 반환 기능
//- 사용자의 타임라인에 방문한 사람들과 그 횟수 구하는 기능
//- user 길이 제한 기능
//- friends 길이 제한 기능
//- visitors 길이 제한 기능
//- 사용자 아이디 알파벳 소문자 제한 기능
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendOfFriends = getFriendOfFriends(user, friends)
    val everyone = getRecommendFriends(friendOfFriends, visitors, getFriends(friends))
    return getRecommendedUsersSequence(visitors, friendOfFriends, everyone)
}

fun getFriends(friends: List<List<String>>): Set<String> {
    val friendsName = mutableSetOf<String>()
    friends.forEach { friend -> friendsName.add(friend[0]) }
    return friendsName
}

fun getFriendOfFriends(user: String, friends: List<List<String>>): List<String> {
    val friendOfFriends = mutableListOf<String>()
    friends.forEach { friend -> if (user != friend[1]) friendOfFriends.add(friend[1]) }
    return friendOfFriends
}

fun getRecommendFriends(visitors: List<String>, friendOfFriends: List<String>, friends: Set<String>) =
    visitors.plus(friendOfFriends).minus(friends).toSet()

private fun setFriendOfFriendsScore(
    recommendFriends: Set<String>, recommendFriendsScore: MutableMap<String, Int>, friendOfFriends: List<String>
) {
    val friendOfFriends = friendOfFriends.groupingBy { friendOfFriend -> friendOfFriend }.eachCount()
    for (recommendFriend in recommendFriends) {
        recommendFriendsScore[recommendFriend] = recommendFriendsScore.getOrDefault(recommendFriend, 0)
            .plus(friendOfFriends.getOrDefault(recommendFriend, 0).times(10))
    }
}

private fun setVisitorsScore(
    recommendFriends: Set<String>, recommendFriendsScore: MutableMap<String, Int>, visitors: List<String>
) {
    val visitors = visitors.groupingBy { visitor -> visitor }.eachCount()
    for (recommendFriend in recommendFriends) {
        recommendFriendsScore[recommendFriend] = recommendFriendsScore.getOrDefault(recommendFriend, 0)
            .plus(visitors.getOrDefault(recommendFriend, 0).times(1))
    }
}

fun getRecommendedUsersSequence(
    visitors: List<String>, friendOfFriends: List<String>, recommendFriends: Set<String>
): List<String> {
    val recommendUsersScore = mutableMapOf<String, Int>()
    setFriendOfFriendsScore(recommendFriends, recommendUsersScore, friendOfFriends)
    setVisitorsScore(recommendFriends, recommendUsersScore, visitors)
    val recommendUsersSequence =
        recommendUsersScore.toSortedMap().toList()
            .sortedByDescending { recommendUserScore -> recommendUserScore.second }.take(5).toMap()
    return recommendUsersSequence.keys.toList()
}