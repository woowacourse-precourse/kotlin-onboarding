package onboarding

fun solution7(
    user: String, friends: List<List<String>>, visitors: List<String>
): List<String> {
    //user와 직접적인 칭구들 배열 생성 -> user[ friend1 : List<> , friend2 : List<>  ]
    //해당 칭구들의 직접적인 친구들 리스트 생성
    //resultList 만들어 칭구들의 점수를 표기 Map<String,Int> 입장 조건 : key값이 있으면 점수 추가 없으면 새로 추가
    //visitor는 이미 user의 실제 칭구면 continue, 아니면 위와 동일하게 동작
    val userDirectFriendList = mutableListOf<String>()
    val resultList = mutableMapOf<String, Int>()

    friends.forEach { list ->
        if (list.contains(user)) {
            userDirectFriendList.add(list[0])
        }
    }

    userDirectFriendList.forEach { directFriend ->
        friends.map {
            if (it[0] == directFriend && resultList.containsKey(it[1])) {
                resultList[it[1]] = resultList.getValue(it[1]) + 10
            } else {
                resultList.put(it[1], 10)
            }
        }
    }

    visitors.forEach {
        if (resultList.containsKey(it)) {
            resultList[it] = resultList.getValue(it) + 1
        } else if (!userDirectFriendList.contains(it)) {
            resultList[it] = 1
        }
    }

    resultList.remove(user)
    resultList.toList().sortedWith(compareBy { it.second })

    return resultList.keys.toList()
}

fun main() {
    val user = "mrko"
    val friends = listOf(
        listOf("donut", "andole"),
        listOf("donut", "jun"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko")
    )
    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
    val list = solution7(
        user, friends, visitors
    )
    println(list)
}
