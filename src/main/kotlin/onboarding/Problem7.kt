package onboarding

/*
기능항목 정리
1. 이미 친구인 유저와 아닌 유저 구분하기
2. 함께 아는 친구인 경우 +10 점 주기
3. visitors 타임라인에 방문한 횟수당 1점 주기
4. 점수별로 내림차순으로 정렬하고 최대 5명까지만 리턴하기
 */
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    var userFriendSet = mutableSetOf<String>() //사용자와 이미 친구인 사람들의 목록
    var allUserSet = mutableSetOf<String>() //사용자를 제외한 모든 사람들의 목록
    var notFriendMap = mutableMapOf<String, Int>() //사용자와 아직 친구가 아닌 사람들의 목록
    var result = arrayListOf<String>() //정답을 담을 어레이 리스트

    friends.forEach { list ->
        var user1 = list[0]
        var user2 = list[1]
        when (user) {
            user1 -> { //첫번째 사람이 사용자인 경우 두번째 사람을 친구목록과 모든유저 목록에 추가
                allUserSet.add(user2)
                userFriendSet.add(user2)
            }

            user2 -> { //두번째 사람이 사용자인 경우 첫번째 사람을 친구목록과 모든유저 목록에 추가
                allUserSet.add(user1)
                userFriendSet.add(user1)
            }

            else -> { //모두 사용자가 아닐 경우 두 사람을 모두 모든유저 목록에 추가
                allUserSet.add(user1)
                allUserSet.add(user2)
            }
        }
    }

    //방문자목록에 있는 사람들을 모든사람 목록에 추가
    visitors.forEach { userName ->
        if (userName != user) allUserSet.add(userName)
    }

    //모든사람 목록에서 친구목록 사람들을 제거하여 친구가 아닌 사람들의 목록을 생성
    var notFriendSet: Set<String> = allUserSet - userFriendSet
    notFriendSet.forEach { userName ->
        notFriendMap[userName] = 0
    }

    //친구가 아닌 사람들중에서 함께 아는 친구가 있을경우 10점 추가
    friends.forEach { list ->
        var user1 = list[0]
        var user2 = list[1]
        for (notFriend in notFriendSet) {
            if (notFriend == user1 && userFriendSet.contains(user2)) notFriendMap[notFriend] =
                notFriendMap[notFriend]!! + 10
            if (notFriend == user2 && userFriendSet.contains(user1)) notFriendMap[notFriend] =
                notFriendMap[notFriend]!! + 10
        }
    }

    //방문횟수 마다 1점 추가
    notFriendSet.forEach { userName ->
        notFriendMap[userName] = notFriendMap[userName]!! + visitors.count { it == userName }
    }

    //0점인 사람들을 목록에서 제거
    notFriendMap=notFriendMap.filter {
        it.value!=0
    } as MutableMap<String, Int>

    //먼저 유저의 이름을 사전순으로 정렬한 후, 점수기준으로 내림차순으로 정렬
    notFriendMap = notFriendMap.toList()
        .sortedBy { it.first }
        .sortedByDescending { it.second }
        .toMap()
        .toMutableMap()

    //최대 5명까지 결과에 추가
    var count = 0
    for (map in notFriendMap) {
        if (count == 5) break
        result.add(map.key)
        count++
    }

    return result.toList()
}
