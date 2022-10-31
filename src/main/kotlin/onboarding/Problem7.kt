package onboarding


fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val lst = mutableListOf<String>()
    val friendMap = hashMapOf<String, Int>()
    val hashList = mutableListOf<Pair<Int, String>>()
    val userFriends = mutableListOf<String>()

    userFriends.add(user)
    for ((f1, f2) in friends) {
        if (f1.equals(user))
            userFriends.add(f2)
        else if (f2.equals(user))
            userFriends.add(f1)
    }

    for ((f1, f2) in friends) {
        if (f1 in userFriends && f2 !in userFriends)
            friendMap[f2] = 10
        else if (f2 in userFriends && f1 !in userFriends)
            friendMap[f1] = 10
    }

    for (v in visitors) {
        if (v in friendMap.keys)
            friendMap[v] = friendMap[v]!! + 1
        else if (v !in userFriends)
            friendMap[v] = 1
    }

    for ((k, v) in friendMap) {
        hashList.add(Pair(v, k))
    }

    hashList.sortWith(compareBy({ -it.first }, { it.second }))

    for ((num, friend) in hashList)
        lst.add(friend)

    return lst
}

fun main() {
    val user = "jun"
    val friends = listOf<List<String>>(
        listOf("donut", "andole"),
        listOf("donut", "jun"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko"),
    )
    val visitors = listOf<String>("bedi", "bedi", "donut", "bedi", "shakevan")

    print(solution7(user, friends, visitors))
}