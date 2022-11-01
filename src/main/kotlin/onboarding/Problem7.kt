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
    //방문한 친구 목록 추가 함수
    visitorFriend = addVisitorFriend(user, visitorFriend, visitors)
    //지인친구 목록 추가 함수
    acquaintance = addAcquaintance(user, acquaintance, visitorFriend, friends, userFriends as MutableList<String>)
    //지인친구 점수 추가 함수
    acquaintanceScore(acquaintance, recommendedScore)
    //방문자 점수 추가 함수
    vistorFriendScore(visitorFriend, recommendedScore)
    //최종 5등 보여주기

    return sortHashMap(recommendedScore)
}

fun getUserFriend(user: String, friends: List<List<String>>): List<String> {
    val friendList = mutableListOf<String>()
    for (i in friends) {
        if (user == i[1]) friendList.add(i[0])
        if (user == i[0]) friendList.add(i[1])
    }
    return friendList

}

fun addVisitorFriend(user: String, visitorFriend: MutableList<String>, visitors: List<String>): MutableList<String> {
    for (i in 0..visitors.size - 1) {
        //방문자 목록추가
        visitorFriend.add(visitors[i])
        //자신은 방문자 목록에서 제외
        visitorFriend.remove(user)
    }
    return visitorFriend
}

fun addAcquaintance(user: String, acquaintance: MutableList<String>, visitorFriend: MutableList<String>, friends: List<List<String>>, userFreind: MutableList<String>): MutableList<String> {

    for (i in 0..friends.size - 1) {
        for (j in 0..userFreind.size - 1) {
            if (friends[i][0].contains(userFreind[j])) acquaintance.add(friends[i][1])
            //친구 지인 목록 추가
            if (friends[i][1].contains(userFreind[j])) acquaintance.add(friends[i][0])
        }
        for (k in 0..userFreind.size - 1) {
            //자신의 친구는 지우기
            acquaintance.remove(userFreind[k])
            //방문자에서도 자신의 친구는 지우기
            visitorFriend.remove(userFreind[k])
        }
        //지인 목록에서도 자신은 제외
        acquaintance.remove(user)
    }
    return acquaintance
}

fun acquaintanceScore(acquaintance: MutableList<String>, recommendedScore: HashMap<String, Int>): HashMap<String, Int> {
    for (i in 0..acquaintance.size - 1) {
        //HasMap의 키를 이름으로 설정하여 키값이 동일하면 점수를 추가
        if (recommendedScore.containsKey(acquaintance[i])) {
            val count = recommendedScore.get(acquaintance[i])?.plus(10)
            //점수가 0점에서 시작하여 키"이름"이 같을때마다 10점씩 추가
            if (count != null) {
                recommendedScore.put(acquaintance[i], count.toInt())
            }
            //이름이 동일하지 않고 처음 나오면 10점
        } else {
            recommendedScore.put(acquaintance[i], 10)
        }
    }
    return recommendedScore
}

fun vistorFriendScore(visitorFriend: MutableList<String>, recommendedScore: HashMap<String, Int>): HashMap<String, Int> {
    for (i in 0..visitorFriend.size - 1) {
        //HasMap의 키를 이름으로 설정하여 키값이 동일하면 점수를 추가
        if (recommendedScore.containsKey(visitorFriend[i])) {
            //점수가 0점에서 시작하여 키"이름"이 같을때마다 1점씩 추가
            val count = recommendedScore.get(visitorFriend[i])?.plus(1)
            if (count != null) {
                recommendedScore.put(visitorFriend[i], count.toInt())
            }
        } else {
            recommendedScore.put(visitorFriend[i], 1)
        }
    }
    return recommendedScore
}

fun sortHashMap(recommendedScore: HashMap<String, Int>): MutableList<String> {
    val result = mutableListOf<String>()
    val sortHashMap = LinkedList(recommendedScore.entries)
    //점수를 기준으로 정렬


    //5명까지만 추천친구에 띄워줄수 있다
    //문자열로 받아 이름만 가져온다
    sortHashMap.sortBy { it.key }
    sortHashMap.sortByDescending { it.value }
    if (sortHashMap.size > 5) {
        for (i in 0..4) {
            result.add(sortHashMap[i].toString().split("=")[0])
        }
    } else {
        for (i in 0..sortHashMap.size - 1) {
            result.add(sortHashMap[i].toString().split("=")[0])
        }
    }

    println(result)
    println(sortHashMap)
    return result
}