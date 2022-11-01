package onboarding

fun solution7(user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    val answer: List<String>
    val friendPointMap: HashMap<String, Int> = HashMap()
    val userFriends = mutableListOf<String>()

    // friend of friend 점수 계산 함수
    calculateFriendOfFriend(friends, user, friendPointMap, userFriends)

    
}

// 친구의 친구 점수 계산 함수
private fun calculateFriendOfFriend(
    friends: List<List<String>>,
    user: String,
    friendPointMap: HashMap<String, Int>,
    userFriends: MutableList<String>
) {

    // 친구만 골라내기
    for (friend in friends) {
        if (friend[0] == user) userFriends.add(friend[1])
        else if (friend[1] == user) userFriends.add(friend[0])
    }

    // 친구의 친구 찾아서 점수 매기기
    for (friend in friends) {
        // friend[0] = 유저의 친구, friend[1] = 친구의 친구
        if (userFriends.contains(friend[0])) add10(friendPointMap, friend[1])
        // friend[0] = 친구의 친구, friend[1] = 유저의 친구
        else if (userFriends.contains(friend[1])) add10(friendPointMap, friend[0])
    }
}

// 10점 주기 함수
private fun add10(friendPointMap: HashMap<String, Int>, friendOfFriend: String) {
    // 이미 등록된 친구의 친구라면 10점을 plus 해준다.
    if (friendPointMap.containsKey(friendOfFriend)) {
        val point = friendPointMap[friendOfFriend]!!.plus(10)
        friendPointMap[friendOfFriend] = point
    }
    // 그렇지 않다면 새로 10점으로 등록해준다.
    else {
        friendPointMap[friendOfFriend] = 10
    }
}
