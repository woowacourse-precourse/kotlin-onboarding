package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var friendList = listOf<String>()
    var non_friendList = mutableMapOf<Int, String>()

    friendList = checkFriends(user, friends)
    return friendList
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



