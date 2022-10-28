package onboarding

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    // user의 친구 찾기
    var user_friends = arrayListOf<String>()

    for (index in friends.indices) {
        if (friends[index].contains(user)) {
            if (friends[index][0].equals(user))
                user_friends.add(friends[index][1])
            else
                user_friends.add(friends[index][0])
        }
    }

    // 사용자와 함께 아는 친구에 따라 점수 주기
    var friend_score : HashMap<String, Int> = hashMapOf()

    for (user_friend in user_friends.indices){
        val friend_name = user_friends[user_friend]
        for (index in friends.indices) {
            if (friends[index].contains(friend_name)){
                if (!friends[index].contains(user)){
                    var name = friends[index][1]
                    if (friends[index][1].equals(friend_name))
                        name = friends[index][0]

                    if (friend_score.containsKey(name))
                        friend_score.replace(name, friend_score.get(name)!! +10)
                    else
                        friend_score.put(name,10)
                }
            }
        }
    }

    for (visitor in visitors.indices){
        val name = visitors[visitor]
        if (friend_score.containsKey(name))
            friend_score.replace(name, friend_score.get(name)!! +1)
        else
            friend_score.put(name,10)
    }
    // 정렬
    val newList = friend_score.toList().sortedWith(
            compareBy(
                    { -(it.second) },
                    { it.first }
            )
    )

    // 답 선정
    val answer = mutableListOf<String>()
    for ((key, value) in newList){
        if ((answer.size == 5) or (value == 0))
            break
        if (user_friends.contains(key))
            continue
        answer.add(key)
    }
    return answer
}

