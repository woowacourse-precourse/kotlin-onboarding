package onboarding

import java.util.*
import kotlin.collections.HashSet

const val FRIEND_SCORE = 10
const val VISITOR_SCORE = 1
const val MAX_USER = 5

/**
 * Returns friends score of each user.
 */
fun calculateFriendScore(user: String, friendGraph: Map<String, Set<String>>): Map<String, Int> {
    val result = mutableMapOf<String, Int>()
    if(friendGraph[user] == null) return result
    val usersFriend = friendGraph[user]!!
    for(otherUser in friendGraph) {
        if(otherUser.key == user || usersFriend.contains(otherUser.key)) continue
        val otherUsersFriend = otherUser.value
        result[otherUser.key] = usersFriend.intersect(otherUsersFriend).size * FRIEND_SCORE
    }
    return result
}

/**
 * Returns visitor score of each user.
 */
fun calculateVisitScore(user: String, visitors: List<String>, friendGraph: Map<String, Set<String>>): Map<String, Int> {
    val result = mutableMapOf<String, Int>()
    val userFriends = friendGraph[user]!!
    for(visitor in visitors) {
        if(userFriends.contains(visitor)) continue
        if(result[visitor] == null) result[visitor] = VISITOR_SCORE
        else result[visitor] = result[visitor]!! + VISITOR_SCORE
    }
    return result
}

/**
 * Returns recommendation score of each user for [user].
 */
fun calculateScore(visitorScore: Map<String, Int>, friendScore: Map<String, Int>): Map<String, Int> {
    val result = mutableMapOf<String, Int>()
    for(score in visitorScore) {
        if(result[score.key] == null) result[score.key] = score.value
        else result[score.key] = result[score.key]!! + score.value
    }
    for(score in friendScore) {
        if(result[score.key] == null) result[score.key] = score.value
        else result[score.key] = result[score.key]!! + score.value
    }
    return result
}


/**
 * Returns a graph of [friends].
 */
fun makeFriendGraph(friends: List<List<String>>): Map<String, Set<String>> {
    val result = mutableMapOf<String, HashSet<String>>()
    for(relation in friends) {
        val friendA = relation[0]
        val friendB = relation[1]
        if(result[friendA] == null) result[friendA] = hashSetOf(friendB)
        else result[friendA]?.add(friendB)
        if(result[friendB] == null) result[friendB] = hashSetOf(friendA)
        else result[friendB]?.add(friendA)
    }
    return result
}

/**
 * Returns sorted list of [friendList] based on [scores].
 */
fun sortFriends(friendList: List<String>, scores: Map<String, Int>): List<String> {
    var sortedList = listOf<String>()
    sortedList = friendList.sorted()
    sortedList = sortedList.sortedWith(compareByDescending<String> {scores[it]})
    return sortedList
}


/**
 * Returns list of recommended friends for [user].
 */
fun recommendFriend(user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    val friendGraph = makeFriendGraph(friends)
    val friendScore = calculateFriendScore(user, friendGraph)
    val visitorScore = calculateVisitScore(user, visitors, friendGraph)
    val scores = calculateScore(visitorScore, friendScore)
    var userList = scores.keys.toList()
    userList = sortFriends(userList, scores)

    if(userList.size <= MAX_USER) return userList
    else return userList.slice(0 until MAX_USER)
}


fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    return recommendFriend(user, friends, visitors)
}
