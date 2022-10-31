package onboarding
fun checkFriend(
        friendRelations: Map<String,Set<String>>,
        user: String
): Map<String, Int> {
    val data = mutableMapOf<String,Int>()
    val userFriends = friendRelations[user]!!.toList()
    for(userFriend in userFriends){
        val ufriendfriends = friendRelations[userFriend]!!.toList()
        for(friend in ufriendfriends){
            if(friend == user)
                continue
            if(!data.containsKey(friend))
                data[friend]=0
            data[friend] = data[friend]!! + 10
        }
    }
    return data
}
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val friendRelations = mutableMapOf<String,MutableSet<String>>()
    var score = mutableMapOf<String,Int>()
    val answer = mutableListOf<String>()
    // 1. friend 관계도 생성( 인물 관계 정리)
    for(friend in friends){
        val friendA=friend[0]
        val friendB=friend[1]
        if(!friendRelations.containsKey(friendA))
            friendRelations[friendA]= mutableSetOf()
        if(!friendRelations.containsKey(friendB))
            friendRelations[friendB]= mutableSetOf()
        friendRelations[friendA]?.add(friendB)
        friendRelations[friendB]?.add(friendA)
    }
    // 2. 사용자와 함께 아는 친구의 수만큼 점수 부여
    if(friendRelations.containsKey(user)) {
        score = checkFriend(friendRelations, user) as MutableMap<String, Int>
    }
    // 3. 사용자 타임라인 방문 횟수만큼 점수 부여
    for(visitor in visitors){
        // 이미 친구인 경우는 제외
        if(friendRelations[user]!!.toList().contains(visitor))
            continue
        if(!score.containsKey(visitor)){
            score[visitor] = 0
            score[visitor] = score[visitor]!! + 1
            continue
        }
        score[visitor] = score[visitor]!! + 1
    }
    // 4.
    val datas = score.toList().sortedWith(
            compareByDescending<Pair<String,Int>> {
                it.second
            }.thenBy{
                it.first
            }
    )
    for(data in datas){
        if(answer.size==5)
            break
        answer.add(data.first)
    }
    return answer
}
