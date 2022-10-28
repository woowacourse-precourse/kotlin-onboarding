package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val hashMapPoint = hashMapOf<String, Int>()
    val userFriends = mutableListOf<String>()

    // user와 친구인 사용자를 찾는 기능
    friends.forEach {
        when (user) {
            it[0] -> userFriends.add(it[1])
            it[1] -> userFriends.add(it[0])
        }
    }

    // user와 함께 아는 사용자에게 10점을 주는 기능
    friends.forEach {
        if (it[0] in userFriends && user != it[1])
            hashMapPoint[it[1]] = hashMapPoint.getOrDefault(it[0], 0) + 10
        else if ( it[1] in userFriends && user != it[0])
            hashMapPoint[it[0]] = hashMapPoint.getOrDefault(it[1], 0) + 10
    }

    // user 타임라인에 방문한 시용자에게 1점을 주는 기능
    for (visitor in visitors){
        if (visitor in userFriends) continue
        hashMapPoint[visitor] = hashMapPoint.getOrDefault(visitor, 0) + 1
    }

    return listOf()

}
