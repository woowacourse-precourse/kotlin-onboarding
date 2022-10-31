package onboarding

import org.assertj.core.condition.Not
import javax.lang.model.type.NullType

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val result : List<String>
    val resultMap = mutableMapOf<String, Int>()
    val friendMap = mutableMapOf<String, MutableList<String>>()

    friends.forEach{
        if (friendMap.containsKey(it[0])) {
            requireNotNull(friendMap[it[0]]).add(it[1])
        }
        else{
            friendMap[it[0]] = mutableListOf(it[1])
        }

        if (friendMap.containsKey(it[1])) {
            requireNotNull(friendMap[it[1]]).add(it[0])
        }
        else {
            friendMap[it[1]] = mutableListOf(it[0])
        }
    }

    friendMap[user]?.forEach { friend ->
        requireNotNull(friendMap[friend]).filterNot { it == user }.forEach{ friendOfFriend ->
            if (resultMap.containsKey(friendOfFriend)) {
                resultMap[friendOfFriend] = resultMap.getValue(friendOfFriend) + 10
            }
            else {
                resultMap[friendOfFriend] = 10
            }
        }
    }
    visitors.filterNot { friendMap[user]?.contains(it) ?: false }.forEach{
        if (resultMap[it] == null) {
            resultMap[it] = 1
        }
        else {
            resultMap[it] = resultMap.getValue(it) + 1
        }
    }

    result = resultMap.toList().sortedByDescending { it.second }.map { it.first } .take(5)

    return result
}
