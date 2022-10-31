package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val result = mutableListOf<String>()
    val friendMap = HashMap<String, MutableList<String>>()
    val scoreMap = HashMap<String, Int>()

    friends.forEach { list ->
        val person1 = list[0]
        val person2 = list[1]
        // 친구 관계를 쌍방으로 하여 맵에 저장한다. 키는 이름, 값은 리스트로 선언하여 한 명의 유저에 대하여 친구 목록으로 넣는다.
        with(friendMap) {
            this.put(person1, getOrDefault(person1, mutableListOf(person2)))?.add(person2)
            this.put(person2, getOrDefault(person2, mutableListOf(person1)))?.add(person1)
        }
    }
    // 유저의 친구의 친구를 탐색하여 10점씩 더해 스코어 맵에 저장한다.
    friendMap[user]?.forEach { userFriends ->
        friendMap[userFriends]?.forEach { friend ->
            //친구 중 user를 제외하고 스코어 맵에 넣는다.
            if (friend != user) {
                scoreMap[friend] = scoreMap.getOrDefault(friend, 0) + 10
            }
        }
    }

    visitors.forEach {
        // 유저의 친구일때는 스코어 맵에 넣지 않는다.
        if (friendMap[user]?.contains(it) != true) {
            scoreMap[it] = scoreMap.getOrDefault(it, 0) + 1
        }
    }
    // 값으로 정렬한 뒤, 값이 같다면 이름으로 정렬한다.
    scoreMap.toList().sortedWith(
        compareBy({ it.second }, { it.first })
    )
    // 정렬된 스코어 맵에 최대 5개 까지 결과 리스트에 넣는다.
    run loop@{
        scoreMap.forEach { (name, _) ->
            if (result.size != 5) {
                result.add(name)
            } else {
                return@loop
            }
        }
    }

    return result
}
