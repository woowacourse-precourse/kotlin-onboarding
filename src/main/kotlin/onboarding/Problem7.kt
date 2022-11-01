package onboarding

import java.util.*
import kotlin.collections.HashMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    //user친구
    val userFriends = getUserFriend(user, friends)
    //아는 친구의친구 지인
    var acquaintance = mutableListOf<String>()
    //방문한 사람들
    var visitorFriend = mutableListOf<String>()
    //추천 친구 점수
    val recommendedScore = HashMap<String, Int>()


//    return sortHashMap(recommendedScore)
}

fun getUserFriend(user: String, friends: List<List<String>>) : List<String>{
    val friendList = mutableListOf<String>()
    for (i in friends){
        if (user == i[1]) friendList.add(i[0])
        if (user == i[0]) friendList.add(i[1])
    }
    return friendList

}