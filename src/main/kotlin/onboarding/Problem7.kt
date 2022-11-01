package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun getMyFriendsList(user: String, friends: List<List<String>>): HashSet<String> {
    var myFriendsSet = hashSetOf<String>()

    for(friend in friends) {
        when (user) {
            friend[0] -> myFriendsSet.add(friend[1])
            friend[1] -> myFriendsSet.add(friend[0])
        }
    }

    return myFriendsSet
}
