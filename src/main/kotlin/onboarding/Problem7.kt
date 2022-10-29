package onboarding

import kotlin.collections.HashMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    // 사용자의 친구 찾기
    val userFriends = arrayListOf<String>()

    for (i in friends.indices) {
        if (friends[i].contains(user)) {
            if (friends[i][0] == user)
                userFriends.add(friends[i][1])
            else
                userFriends.add(friends[i][0])
        }
    }

    // 사용자와 함께 아는 친구에 따라 점수 주기
    val friendScore : HashMap<String, Int> = hashMapOf()

    for (user_friend in userFriends.indices){
        val friendName = userFriends[user_friend]
        for (i in friends.indices) {
            if (friends[i].contains(friendName)){
                if (!friends[i].contains(user)){
                    var name = friends[i][1]
                    if (friends[i][1] == friendName)
                        name = friends[i][0]
                    friendScore[name] = friendScore[name]?.plus(10) ?: 10
                }
            }
        }
    }

    // 방문 횟수따라 점수 주기
    for (visitor in visitors.indices){
        val name = visitors[visitor]
        friendScore[name] = friendScore[name]?.plus(1) ?: 1
    }

    // 점수와 이름 순으로 정렬
    val newList = friendScore.toList().sortedWith(
            compareBy(
                    { -(it.second) },
                    { it.first }
            )
    )

    // 답 선정
    val answer = mutableListOf<String>()
    for ((name, score) in newList){
        if ((answer.size == 5) or (score == 0))
            break
        if (userFriends.contains(name))
            continue
        answer.add(name)
    }
    return answer
}

