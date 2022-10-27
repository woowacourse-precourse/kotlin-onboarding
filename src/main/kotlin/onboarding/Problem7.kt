package onboarding


fun findShare(friends: List<List<String>>, user_friends: List<String>, user: String): MutableMap<String, Int>{
    // user의 friends와 함께 아는 친구가 몇명인지 구하기
    val cnt_friend = mutableMapOf<String, Int>()
    for (people in user_friends) {
        for ((first, last) in friends) {
            if (first == user || last == user) continue
            if (first == people) {
                if (!cnt_friend.containsKey(last)) cnt_friend[last] = 10
                else cnt_friend[last] = cnt_friend[last]!! + 10
            }
            if (last == people) {
                if (!cnt_friend.containsKey(first)) cnt_friend[first] = 10
                else cnt_friend[first] = cnt_friend[first]!! + 10
            }
        }
    }
    return cnt_friend
}

fun findFriends(friends: List<List<String>>, user: String): List<String>{
    // user의 friends에는 어떤 친구들이 있는지 구하기
    val peoples = ArrayList<String>()
    for ((first, last) in friends){
        if (first == user) peoples.add(last)
        if (last == user) peoples.add(first)
    }
    return peoples
}

fun visitPeople(share_friends: MutableMap<String, Int>, visit: String): MutableMap<String, Int>{
    // 방문객들 +1점
    if (!share_friends.containsKey(visit)) share_friends[visit] = 1
    else share_friends[visit] = share_friends[visit]!! + 1
    return share_friends
}

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val user_friends = findFriends(friends, user) // user와 친구인 리스트
    var share_friends = findShare(friends, user_friends, user) // 함께 아는 친구들

    for (visit in visitors) {
        if (user_friends.contains(visit)) continue          // 방문객과 이미 친구인 경우
        share_friends = visitPeople(share_friends, visit) // 방문횟수 + 1
    }
    share_friends = share_friends.toList().sortedByDescending { it.second }.toMap() as MutableMap // 점수 별 정렬

    val result:List<String> = share_friends.keys.toList()   // Key 즉, 이름 저장

    return result
}
