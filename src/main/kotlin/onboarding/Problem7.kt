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

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}
