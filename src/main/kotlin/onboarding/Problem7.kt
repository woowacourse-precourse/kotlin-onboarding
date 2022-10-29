package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendList = mutableMapOf<String, ArrayList<String>>()
    for (f in friends) {
        if (!friendList.contains(f[0])) friendList[f[0]] = arrayListOf(f[1])
        else friendList[f[0]]?.add(f[1])
        if (!friendList.contains(f[1])) friendList[f[1]] = arrayListOf(f[0])
        else friendList[f[1]]?.add(f[0])
    }
    val userFriendList = friendList[user]
    TODO("프로그램 구현")
}
