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
    val userFriendList = friendList[user] ?: arrayListOf()
    val strangersScore = mutableMapOf<String, Int>()
    for (f in friendList) {
        if (f.key == user || userFriendList.contains(f.key)) continue
        else strangersScore[f.key] = 0
    }
    for (stranger in strangersScore) {
        val strangerName = stranger.key
        val strangerFriendList = friendList[strangerName] ?: arrayListOf()
        for (sf in strangerFriendList) {
            if (userFriendList.contains(sf)) {
                strangersScore[strangerName] = strangersScore[strangerName]!!.plus(10)
            }
        }
    }
    for(v in visitors){
        if (userFriendList.contains(v)) continue
        if (!strangersScore.contains(v)) strangersScore[v] = 1
        else strangersScore[v] = strangersScore[v]!!.plus(1)
    }
    TODO("프로그램 구현")
}
