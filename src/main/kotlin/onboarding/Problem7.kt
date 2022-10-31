package onboarding

import java.util.LinkedList

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val result = listOf<String>()
    
    

    return result
}

fun getFriendInformation(friends: List<List<String>>): Map<String, LinkedList<String>> {
    val friendInformation  = LinkedHashMap<String, LinkedList<String>>()
    for (element in friends) {
        friendInformation[element[0]] = friendInformation[element[0]] ?: LinkedList<String>()
        friendInformation[element[1]] = friendInformation[element[1]] ?: LinkedList<String>()
        friendInformation[element[0]]?.add(element[1])
        friendInformation[element[1]]?.add(element[0])
    }
    return friendInformation
}
