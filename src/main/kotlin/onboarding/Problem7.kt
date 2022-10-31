package onboarding

private lateinit var friendsMap: HashMap<String, Int>
private lateinit var knowFriends: Set<String>

data class Score(
    val user: String,
    var score: Int
)

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    // friend map을 만든다.
    friendsMap = getFriendsScore(friends)
    // 유저가 알고 있는 친구 리스트를 만든다.
    knowFriends = findUserFriends(user, friends)
    // User가 알고있는 친구의 친구면 +10
    findKnowFriends(friends, knowFriends)
    // visitors에 있는 친구를 map에서 +1
    visitFriends(visitors)
    // map을 value값으로 정렬하고 같으면 이름으로 정렬한다.
    // map키를 5까지 출력한다.
    return getTopFive(user)
}

fun findKnowFriends(friends: List<List<String>>, knowFriends: Set<String>) {
    friends.forEach {
        if (knowFriends.contains(it[0])) {
            friendsMap[it[1]] = friendsMap[it[1]]?.plus(10) ?: 0
        }
        if (knowFriends.contains(it[1])) {
            friendsMap[it[0]] = friendsMap[it[0]]?.plus(10) ?: 0
        }
    }
}

fun getTopFive(user: String): List<String> {
    val onlyKnowFriend = checkUserAndFriends(friendsMap, user)
    val onlyHasPointUser = checkZeroPointUser(onlyKnowFriend)
    val pairList = onlyHasPointUser.toPair()
    val sortedList = pairList.pairSorted()
    val topFiveList = sortedList.checkMaxSize()
    return topFiveList.toFirstList()
}

// 유저, 이미 친구 제거
fun checkUserAndFriends(friendsMap: Map<String, Int>, user: String) =
    friendsMap.filterKeys { it != user && !knowFriends.contains(it) }

// 점수가 0점인 사람 제거
fun checkZeroPointUser(map: Map<String, Int>) = map.filterValues { it != 0 }

// Pair로 형변환
fun Map<String, Int>.toPair() = this.map { it.toPair() }

// 정렬
fun List<Pair<String, Int>>.pairSorted(): List<Pair<String, Int>> {
    val sortRule =
        compareByDescending<Pair<String, Int>> { it.second }
            .thenBy { it.first }
    return this.sortedWith(sortRule)
}

// 최대 5개까지 반환
fun List<Pair<String, Int>>.checkMaxSize(): List<Pair<String, Int>> {
    return this.filterIndexed { index, _ -> index < 5 }
}

// 이름만 리스트로 반환
fun List<Pair<String, Int>>.toFirstList() = this.map { it.first }

fun visitFriends(visitors: List<String>) {
    visitors.forEach {
        friendsMap[it] = friendsMap[it]?.plus(1) ?: 0
    }
}

fun findUserFriends(user: String, friends: List<List<String>>): Set<String> {
    val list = mutableSetOf<String>()
    friends.forEach { friend ->
        if (user == friend[0]) {
            list.add(friend[1])
        }
        if (user == friend[1]) {
            list.add(friend[0])
        }
    }
    return list
}

private fun getFriendsScore(friends: List<List<String>>): HashMap<String, Int> {
    val map = HashMap<String, Int>()
    friends.forEach { friend ->
        friend.forEach { name ->
            map.put(name, 0)
        }
    }
    return map
}
