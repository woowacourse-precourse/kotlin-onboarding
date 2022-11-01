package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val answer = mutableListOf<String>() // 저장소
    val friend = mutableListOf<String>() // 친구
    val together = mutableListOf<String>() // 함께 아는 친구
    val visitor = mutableListOf<String>() // 방문자

    for (i in 0 until friends.size) { // 친구 찾기

        if (user in friends[i]) {

            if (friends[i][0] != user) {
                friend.add(friends[i][0])
            } else if (friends[i][1] != user) {
                friend.add(friends[i][1])
            }

        }

    }

    for (i in 0 until friends.size) { // 함께 아는 친구 찾기

        for (j in 0 until friend.size) {

            if (friend[j] in friends[i]) {

                if (friends[i][0] != friend[j] && friends[i][0] != user) {
                    together.add(friends[i][0])
                } else if (friends[i][1] != friend[j] && friends[i][1] != user) {
                    together.add(friends[i][1])
                }

            }

        }

    }

    for (i in 0 until visitors.size){ // 방문자 확인

        if (visitors[i] !in friend){
            visitor.add(visitors[i])
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    val recomend= mutableMapOf("" to 0) // 친구추천 목록 // key와 value로 구성

    for (i in 0 until together.size){

        if(together[i] !in recomend){ // 목록에 없으면
            recomend.put(together[i],10) // 10 부여
        }

        if (together[i] in recomend){ // 목록에 있으면
            recomend[together[i]] = recomend[together[i]]!! + 10
        }

    }

    for (n in 0 until visitor.size) {

        if (visitor[n] !in recomend) { // 목록에 없으면
            recomend.put(visitor[n], 1) // 1 부여
        }

        if (visitor[n] in recomend) { // 목록에 있으면
            recomend[visitor[n]] = recomend[visitor[n]]!! + 1
        }
    }
    
    val friend_list=recomend.toList().sortedByDescending { it.second }.toMutableList() // 밸류 기준 내림차순 정렬
    
    for (o in 0 until friend_list.size){ // 5명제한
        if (answer.size==5){ // 5명차면 루프파괴
            break
        }
        if(friend_list[o].second!=0){
            answer.add(friend_list[o].first) // 상위 5명 이름만 입력
        }
    }

    return answer
}
