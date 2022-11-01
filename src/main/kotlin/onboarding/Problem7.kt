package onboarding

fun solution7(user: String, friends: List<List<String>>, visitors: List<String>): List<String> {
    val answer: List<String>
    val friendPointMap: HashMap<String, Int> = HashMap()
    val userFriends = mutableListOf<String>()

    // friend of friend 점수 계산 함수
    calculateFriendOfFriend(friends, user, friendPointMap, userFriends)
    // visitor 점수 계산 함수
    calculateVisitor(friendPointMap, visitors)

    // map을 list로 바꾸고 정렬해서 리턴하는 함수
    answer = getSortedList(friendPointMap, user, userFriends)

    return answer
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

// 방문자들에게 1점 주는 함수
private fun calculateVisitor(friendPointMap: HashMap<String, Int>, visitors: List<String>) {
    // visitor 점수 매기기
    for (visitor in visitors) {
        // 이미 추천 친구가 등록되어 있다면, 값을 가져와 plus 1 을 해준다.
        if (friendPointMap.containsKey(visitor)) {
            val point = friendPointMap[visitor]!!.plus(1)
            friendPointMap[visitor] = point
        }
        // 아니라면 1점으로 초기화해준다.
        else {
            friendPointMap[visitor] = 1
        }
    }
}

// map을 list로 변환 후, 정렬하고 return해주는 함수
private fun getSortedList(
    friendPointMap: HashMap<String, Int>,
    user: String,
    userFriends: MutableList<String>
): List<String> {
    val answer = mutableListOf<String>()
    val friendList = friendPointMap.toList()
    // second(value)먼저 '내림차순'으로 정렬, 같다면 first(이름)으로 '오름차순'으로 정렬
    val sortedList = friendList.sortedWith(compareBy({ -it.second }, { it.first }))

    // List<Pair<String, Int>> -> List<String>
    for (e in sortedList) {
        // 자기 자신, 자기 친구들은 추천 친구에서 제외
        if (e.first == user || userFriends.contains(e.first))
            continue

        answer.add(e.first)

        // 최대 5명 조건, 5명 되면 끝내기 break
        if(answer.size == 5)
            break
    }

    return answer
}
