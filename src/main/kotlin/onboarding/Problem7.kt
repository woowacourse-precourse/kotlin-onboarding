package onboarding

import java.util.*
import kotlin.collections.HashSet

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
