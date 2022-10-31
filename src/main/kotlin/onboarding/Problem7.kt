/*
* 기능 구현
* 1. userFriendList : user 의 친구 목록을 생성하는 기능
* 2. 생성된 친구 목록과 friends 원소들을 체크하여 해당되면 score 에 10점 추가
* 3. 생성된 친구 목록과 visitor 원소들을 체크하여 해당되면 score 에 1점 추가
* 3. score 에서 필터조건에 해당되는 원소들을 내림차순하여 5개만 리턴한다.
* */

package onboarding

fun userFriendList(user : String,
                   friends: List<List<String>>
): MutableList<String> {
    val userFriends = mutableListOf<String>()

    friends.forEach {
        if(it[0] == user) {
            userFriends.add(it[1])
        } else {
            userFriends.add(it[0])
        }
    }

    return userFriends
}


fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val userFriendsList = userFriendList(user, friends)
    val score = mutableMapOf<String, Int>()

    friends.forEach {
        if ((it[0] in userFriendsList) && (it[1] != user)) {
            score[it[1]] = score[it[1]]?.plus(10) ?: 10
        } else if ((it[1] in userFriendsList) && it[0] != user) {
            score[it[0]] = score[it[0]]?.plus(10) ?: 10
        }
    }

    visitors.forEach {
        if (score.containsKey(it)) {
            score[it] = score[it]?.plus(1) ?: 1
        } else {
            score[it] = 0
        }
    }

    return score.filter { (key, value) ->
        key != user && value > 0
    }.toList().sortedByDescending { it.second }.map { it.first }.take(5)

}




