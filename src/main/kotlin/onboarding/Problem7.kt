package onboarding

import java.util.*

fun solution7(user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    var scoreMap = mutableMapOf<String, Int>().setDefaultDataToMap(friends, visitors) // 유저 목록 + 점수를 담을 Map 객체

    val sortList = addScoreToVisitors(visitors, commonFriends(user, friends, scoreMap)).toList().sortedByDescending { it.second }
    scoreMap = sortSameValue(sortList).toMap() as MutableMap //같은 value를 가질 경우에는 이름순으로 정렬해줘야 한다.
    return setResults(scoreMap).subList(0, 3) // 유저명이 모두 정렬 후 저장되어있는 상태이므로, 0번에서 2번까지 총 3개만 반환하도록 한다.
}

private fun MutableMap<String, Int>.setDefaultDataToMap(friends: List<List<String>>, visitors: List<String>) : MutableMap<String, Int> {
    for (user in returnAllUser(friends, visitors)) { // 현재 존재하는 유저명을 담는 Map에 초기 데이터 주입하기
        this[user] = 0
    }
    return this
}

private fun setResults(scoreMap: MutableMap<String, Int>) : MutableList<String> {
    val userNameList = mutableListOf<String>()
    for((key, value) in scoreMap) {
        if(value != 0) { // 예외사항! -> 추천 점수가 0점인 경우 추천하지 않으므로, 제외했다.
            userNameList.add(key) // 실질적으로 반환해줄 리스트에 key값, 즉 유저명을 저장한다.
        }
    }
    return userNameList
}

/**
 * 2차원 배열을 평탄화시키고, 방문자 배열과 합친 후 중복을 제거하는 함수 (배열들에 존재하는 모든 유저명 추려내기)
 */
private fun returnAllUser(friends: List<List<String>>, visitors: List<String>): List<String> {
    return (friends.flatten() + visitors).distinct() //flatten() 은 다차원 배열을 평탄화 시켜주는 메서드이다.
}

/**
 * 현재 유저의 친구가 아는 친구를 추려내기 위한 함수
 */
private fun commonFriends(user: String, friends: List<List<String>>, scoreMap: MutableMap<String, Int>): MutableMap<String, Int> {
    var mScoreMap = scoreMap
    for (friend in friends) {
        val friend = checkUserFriends(user, friend) // 현재 유저와 친구인 유저의 닉네임이 담기는 변수
        checkCommonFriends(friends, friend, user, scoreMap)
    }
    return mScoreMap
}

private fun checkCommonFriends(friends : List<List<String>>, friend : String? , user : String, scoreMap : MutableMap<String, Int>) : MutableMap<String, Int> {
    var mMap = scoreMap
    for (otherFriend in friends) {
        friend?.let {
            val commonFriend = getCommonFriend(user, it, otherFriend) // 현재 유자와 친구인 유저의 친구인 유저명 (다만 null도 들어올 수 있으므로 체크 해야함)
            commonFriend?.let { mMap = addCommonFriendScore(commonFriend, mMap) }
        }
    }
    return mMap
}

/**
 * 파라미터로 들어오는 user 와 친구인 유저명을 반환해주는 함수
 */
private fun checkUserFriends(user: String, friends: List<String>): String? {
    return when (user) {
        friends[0] -> { friends[1] }
        friends[1] -> { friends[0] }
        else -> null
    }
}

/**
 * 현재 유저의 친구인 유저와 친구인 다른 유저를 찾아내는 함수
 */
private fun getCommonFriend(user: String, curFriend: String, friendList: List<String>): String? {
    val mFriend = checkUserFriends(curFriend, friendList)

    return if (mFriend != null && mFriend != user) { // != user를 넣은 이유는, 현재 유저 역시도 친구이므로 이를 배제하기 위해서이다.
        mFriend
    } else null
}

/**
 * 현재 유저와 친구인 유저의 친구에게는 10점이 주어지므로, 유저명-점수 를 갖는 map에 점수를 추가해주는 함수
 */
private fun addCommonFriendScore(friend: String, map: MutableMap<String, Int>): MutableMap<String, Int> {
    map[friend] = map[friend]!! + 10
    return map
}

/**
 * 방문자에게도 점수를 추가해줘야하므로, 각 방문자에게 점수를 추가하도록 하는 함수
 */
private fun addScoreToVisitors(visitors : List<String>, scoreMap: MutableMap<String, Int>) : MutableMap<String, Int> {
    var mScoreMap = scoreMap
    for(visitor in visitors) {
        mScoreMap = addVisitorScore(visitor, scoreMap)
    }
    return mScoreMap
}

/**
 * visitors() 에서 받아온 방문한 유저에게 실질적으로 점수를 map에 담아서 반환해주는 함수
 */
private fun addVisitorScore (friend : String, map : MutableMap<String, Int>) : MutableMap<String, Int>{
    map[friend] = map[friend]!! + 1
    return map
}

/**
 * 같은 점수를 가진 경우에는 이름 순으로 재정렬해주는 함수.
 */
private fun sortSameValue(list : List<Pair<String, Int>>) : List<Pair<String, Int>>{
    var lastKey = ""
    var lastValue = 0
    for(sameScoreFriend in list.indices) {
        list.swapLists(sameScoreFriend, lastKey, lastValue)
        lastKey = list[sameScoreFriend].first
        lastValue = list[sameScoreFriend].second
    }
    return list
}

private fun List<Pair<String, Int>>.swapLists(position : Int, lastKey : String, lastValue : Int) : List<Pair<String, Int>> {
    if(this[position].second == lastValue && this[position].first < lastKey) {
        Collections.swap(this, position, position - 1)
    }
    return this
}