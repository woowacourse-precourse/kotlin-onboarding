package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var scoreMap = mutableMapOf<String, Int>() // 유저 목록 + 점수를 담을 Map 객체

    for (i in returnAllUser(friends, visitors)) { // 현재 존재하는 유저명을 담는 Map에 초기 데이터 주입하기
        scoreMap[i] = 0
    }

    commonFriends(user, friends)

}

/**
 * 2차원 배열을 평탄화시키고, 방문자 배열과 합친 후 중복을 제거하는 함수 (배열들에 존재하는 모든 유저명 추려내기)
 */
private fun returnAllUser(friends: List<List<String>>, visitors: List<String>): List<String> {
    return (friends.flatten() + visitors).distinct()
}

/**
 * 현재 유저의 친구가 아는 친구를 추려내기 위한 함수
 */
private fun commonFriends(user : String, friends : List<List<String>>){

    for (i in friends) {
        val friend = checkUserFriends(user, i) // 현재 유저와 친구인 유저의 닉네임이 담기는 변수
        for (o in friends) {
            if (friend != null) {
                val commonFriend = getCommonFriend(user, friend, o) // 현재 유자와 친구인 유저의 친구인 유저명 (다만 null도 들어올 수 있으므로 체크 해야함)
            }
        }
    }

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
private fun getCommonFriend(user : String, curFriend : String, friendList : List<String>) : String? {
    val mFriend = checkUserFriends(curFriend, friendList)

    if(mFriend != null && mFriend != user) { // != user를 넣은 이유는, 현재 유저 역시도 친구이므로 이를 배제하기 위해서이다.
        return mFriend
    } else return null
}
