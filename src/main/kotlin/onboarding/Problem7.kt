package onboarding

import java.util.*

fun solution7(
        user: String,
        friends: List<List<String>>,
        visitors: List<String>
): List<String> {
    var scoreMap = mutableMapOf<String, Int>() // 유저 목록 + 점수를 담을 Map 객체
    var resultFriends = mutableListOf<String>() // 최종적으로 리턴될 유저 닉네임을 담을 배열
    for (i in returnAllUser(friends, visitors)) { // 현재 존재하는 유저명을 담는 Map에 초기 데이터 주입하기
        scoreMap[i] = 0
    }

    //scoreMap = commonFriends(user, friends, scoreMap) // 점수를 추가한 후 map 객체를 반환하므로 기존에 선언해둔 map 에 덮어씌운다.
    //scoreMap = visitors(visitors, scoreMap) // 점수를 추가한 후 map 객체를 반환하므로 기존에 선언해둔 map 에 덮어씌운다.

    /* 위의 2줄의 재선언이 비효율적이라고 생각되어, 하나의 코드로 합친 후, value 값을 기준으로 정렬했다.
    * List로 변환 후 value (it.second) 로 정렬했다. */
    val sortList = visitors(visitors, commonFriends(user, friends, scoreMap)).toList().sortedByDescending { it.second }


    scoreMap = sortSameValue(sortList).toMap() as MutableMap //같은 value를 가질 경우에는 이름순으로 정렬해줘야 한다.

    for((key, value) in scoreMap) {
        if(value != 0) { // 예외사항! -> 추천 점수가 0점인 경우 추천하지 않으므로, 제외했다.
            resultFriends.add(key) // 실질적으로 반환해줄 리스트에 key값, 즉 유저명을 저장한다.
        }
    }
    return resultFriends.subList(0, 3) // 유저명이 모두 정렬 후 저장되어있는 상태이므로, 0번에서 2번까지 총 3개만 반환하도록 한다.
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
    for (i in friends) {
        val friend = checkUserFriends(user, i) // 현재 유저와 친구인 유저의 닉네임이 담기는 변수
        for (o in friends) {
            if (friend != null) {
                val commonFriend = getCommonFriend(user, friend, o) // 현재 유자와 친구인 유저의 친구인 유저명 (다만 null도 들어올 수 있으므로 체크 해야함)
                if (commonFriend != null) {
                    mScoreMap = addCommonFriendScore(commonFriend, scoreMap)
                }
            }
        }
    }
    return mScoreMap
}

/**
 * 파라미터로 들어오는 user 와 친구인 유저명을 반환해주는 함수
 */
private fun checkUserFriends(user: String, friends: List<String>): String? {
    return when (user) {
        friends[0] -> {
            friends[1]
        }

        friends[1] -> {
            friends[0]
        }

        else -> null
    }
}

/**
 * 현재 유저의 친구인 유저와 친구인 다른 유저를 찾아내는 함수
 */
private fun getCommonFriend(user: String, curFriend: String, friendList: List<String>): String? {
    val mFriend = checkUserFriends(curFriend, friendList)

    if (mFriend != null && mFriend != user) { // != user를 넣은 이유는, 현재 유저 역시도 친구이므로 이를 배제하기 위해서이다.
        return mFriend
    } else return null
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
private fun visitors(visitors : List<String>, scoreMap: MutableMap<String, Int>) : MutableMap<String, Int> {
    var mScoreMap = scoreMap
    for(i in visitors) {
        mScoreMap = addVisitorScore(i, scoreMap)
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
    for(i in list.indices) {
        if(list[i].second == lastValue && list[i].first < lastKey) {
            Collections.swap(list, i, i-1)
        }
        lastKey = list[i].first
        lastValue = list[i].second
    }
    return list
}