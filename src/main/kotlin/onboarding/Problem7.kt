package onboarding

import java.util.SortedMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var i:Int = 0
    var friendsList: List<String> = checkFriends(user, friends)
    var nonFriendsList: Map<String, Int> = checkNonFriends(user, friends, friendsList, visitors)
    var sortedMap: List<Pair<String, Int>> = nonFriendsList.toList().sortedByDescending { it.second }
    var result: MutableList<String> = mutableListOf()

    while (i < 5 && i < sortedMap.size){
        if (sortedMap[i].second == 0)
            break
        result.add(sortedMap[i].first)
        i++
    }
    return result
}

fun checkFriends(user: String, friends: List<List<String>>) : List<String> {
    var list = mutableListOf<String>()

    for (friend in friends){
        if (friend[0] == user && !(friend[1] in list))
            list.add(friend[1])
        if (friend[1] == user && !(friend[0] in list))
            list.add(friend[0])
    }
    return list
}

fun checkNonFriends(user: String,
                    friends: List<List<String>>,
                    friendList: List<String>,
                    visitors: List<String>
): Map<String, Int> {
    var list: MutableMap<String, Int> = mutableMapOf()

    for (friend in friends) {
        if (friend[0] == user || friend[1] == user)
            continue
        if (friend[0] in friendList && friend[1] in friendList)
            continue
        if (friend[0] in friendList) {
            if (list.containsKey(friend[1]))
                list[friend[1]] = list[friend[1]]!! + 10
            else
                list[friend[1]] = 10
        }
        if (friend[1] in friendList) {
            if (list.containsKey(friend[0]))
                list[friend[0]] = list[friend[0]]!! + 10
            else
                list[friend[0]] = 10
        }
    }

    for (visitor in visitors) {
        if (visitor in friendList)
            continue
        if (list.containsKey(visitor))
            list[visitor] = list[visitor]!! + 1
        else
            list[visitor] = 1
    }
    return list
}


