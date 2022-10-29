package onboarding

import java.util.*


//user와 직접적인 칭구들 배열 생성 -> user[ friend1 : List<> , friend2 : List<>  ]
//해당 칭구들의 직접적인 친구들 리스트 생성
//resultList 만들어 칭구들의 점수를 표기 Map<String,Int> 입장 조건 : key값이 있으면 점수 추가 없으면 새로 추가
//visitor는 이미 user의 실제 칭구면 continue, 아니면 위와 동일하게 동작

fun solution7(
    user: String, friends: List<List<String>>, visitors: List<String>
): List<String> {
    val userDirectFriendList = mutableListOf<String>()
    val resultList = mutableMapOf<String, Int>()

    //user와 직접 친구 고르기
    friends.forEach { list ->
        if (list.contains(user)) userDirectFriendList.add(list[0])
    }

    //유저와 함께 아는 친구 점수 부여
    userDirectFriendList.forEach { directFriend ->
        friends.forEach {
            if (it[0] == directFriend && resultList.containsKey(it[1])) resultList[it[1]] =
                resultList.getValue(it[1]) + 10
            else resultList[it[1]] = 10
        }
    }

    //방문한 사람 점수 부여
    visitors.forEach {
        if (resultList.containsKey(it)) resultList[it] = resultList.getValue(it) + 1
        else if (!userDirectFriendList.contains(it)) resultList[it] = 1

    }
    //이용자 제거
    resultList.remove(user)
    //점수 높은순으로 정렬 근데 알파벳

    val keySortedList =
        resultList.toSortedMap().toList().sortedWith(compareBy<Pair<String, Int>> { it.second }.reversed())

    val answer = keySortedList.toMap().keys.toList()

    return if (answer.size > 5)
        answer.subList(0, 5)
    else
        answer
}

fun main() {
    val user = "mrko"
    val friends = listOf(
        listOf("donut", "jun"),
        listOf("donut", "andole"),
        listOf("donut", "mrko"),
        listOf("shakevan", "andole"),
        listOf("shakevan", "jun"),
        listOf("shakevan", "mrko")
    )
    val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan", "koko", "haha", "kuku")
    val list = solution7(
        user, friends, visitors
    )
    println(list)
}
