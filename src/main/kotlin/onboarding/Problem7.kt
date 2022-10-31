package onboarding

import kotlin.collections.HashMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val userFriends = findUserFriends(user, friends)
    val friendScore : HashMap<String, Int> = hashMapOf()

    // 사용자와 함께 아는 친구에 따라 점수 주기
    for (user_friend in userFriends.indices){
        val friendName = userFriends[user_friend]
        for (i in friends.indices) {
            if (friends[i].contains(friendName)){
                if (!friends[i].contains(user)){
                    var name = friends[i][1]
                    if (friends[i][1] == friendName)
                        name = friends[i][0]
                    friendScore[name] = friendScore[name]?.plus(10) ?: 10
                }
            }
        }
    }


    countVisitorScore(visitors, friendScore)

    val sortedList = sortList(friendScore.toList())

    return chooseRecommendationList(sortedList, userFriends)
}
fun findUserFriends(user: String,
                    friends: List<List<String>>): ArrayList<String> {
    val userFriends = arrayListOf<String>()
    for (i in friends.indices) {
        if (friends[i].contains(user)) {
            if (friends[i][0] == user)
                userFriends.add(friends[i][1])
            if (friends[i][1] == user)
                userFriends.add(friends[i][0])
        }
    }
    return userFriends
}
fun countVisitorScore(visitors: List<String>,
                      friendScore: HashMap<String, Int>){
    for (visitor in visitors.indices){
        val name = visitors[visitor]
        friendScore[name] = friendScore[name]?.plus(1) ?: 1
    }
}
fun sortList(friendScore: List<Pair<String, Int>>): List<Pair<String, Int>> {

    return friendScore.sortedWith(
            compareBy(
                    { -(it.second) },
                    { it.first }
            )
    )
}
fun chooseRecommendationList(sortedList: List<Pair<String, Int>>,
                             userFriends: ArrayList<String>): MutableList<String> {
    val answer = mutableListOf<String>()

    for ((name, score) in sortedList){
        if ((answer.size == 5) or (score == 0))
            break
        if (userFriends.contains(name))
            continue
        answer.add(name)
    }

    return answer
}
