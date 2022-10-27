package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var friendList = listOf<String>()
    var non_friendList = mapOf<String, Int>()

    friendList = checkFriends(user, friends)
    non_friendList = checkNonFriends(user, friends, friendList, visitors)

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
): Map<String, Int>{
    var list = mutableMapOf<String, Int>()

    for (friend in friends){
        if (friend[0]==user || friend[1]==user)
            continue
        if (friend[0] in friendList && friend[1] in friendList)
            continue
        if (friend[0] in friendList){
            if (list.containsKey(friend[1]))
                list.put(friend[1], list.get(friend[1])!! + 10)
            else
                list.put(friend[1], 10)
        }
        if (friend[1] in friendList){
            if (list.containsKey(friend[0]))
                list.put(friend[0], list.get(friend[0])!! + 10)
            else
                list.put(friend[0], 10)
        }
    }
    return list
}

