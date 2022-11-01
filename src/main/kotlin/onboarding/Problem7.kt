package onboarding

import org.assertj.core.api.Assertions

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    // friends와 visitors 사이에서 unique 값을 추출
    val temp = mutableListOf<String>()

    for (i in 0..friends.size-1){
        temp.add(friends[i][0])
        temp.add(friends[i][1])
    }

    for (i in 0..visitors.size-1){
        temp.add(visitors[i])
    }

    val friends_name_set: Set<String> = convertToSet(temp)

    // friends와 visitors들의 unique 값을 담을 리스트
    var friends_name_unique: List<String> = friends_name_set.toList().sorted()

    // friends 추천 점수를 넣을 리스트
    val score = mutableListOf<Int>()
    for (i in 0..friends_name_unique.size-1){
        score.add(0)
    }

      /*
       * 10점
       * */

    // user의 이름이 friends 리스트에 있는지 확인한다.
    for (i in 0..friends.size-1) {
        if ( user in friends[i][0] ) {
            // friends[i][0] 의 친구 관계를 확인
            for (k in 0..friends.size-1) {
                if (friends[i][1] in friends[k][0]) {
                    // friends[k][1]에 10점
                    for ( j in 0..friends_name_unique.size-1){
                        if (friends_name_unique[j] == friends[k][1] && friends[k][1] != user){
                            score[j] += 10
                        }
                    }
                }
                else if (friends[i][1] in friends[k][1]) {
                    // friends[k][0]에 10점
                    for ( j in 0..friends_name_unique.size-1){
                        if (friends_name_unique[j] == friends[k][0] && friends[k][0] != user){
                            score[j] += 10
                        }
                    }

                }
            }
        }
        if ( user in friends[i][1] ) {
            // friends[i][0] 의 친구 관계를 확인
            for (k in 0..friends.size-1) {
                if (friends[i][0] in friends[k][0]) {
                    // friends[k][1]에 10점
                    for ( j in 0..friends_name_unique.size-1){
                        if (friends_name_unique[j] == friends[k][1] && friends[k][1] != user){
                            score[j] += 10
                        }
                    }
                }
                else if (friends[i][0] in friends[k][1]) {
                    // friends[k][0]에 10점
                    for ( j in 0..friends_name_unique.size-1){
                        if (friends_name_unique[j] == friends[k][0] && friends[k][0] != user){
                            score[j] += 10
                        }
                    }
                }
            }
        }
    } // end of 10점

    /*
     * 1점
     * */
    // 친구가 아닌 visitors들을 담아둘 리스트
    val selectedVisitors = visitors.toMutableList()
    for (i in 0..friends.size-1) {
        // 유저와의 친구를 삭제
        if (user in friends[i][0]) {
            if (friends[i][1] in visitors){
                // visitors에서 삭제
                for (j in 0..visitors.size-1){
                    if (friends[i][1] == visitors[j]){
                        selectedVisitors.remove(friends[i][1])
                    }
                }
            }
        }
        else if (user in friends[i][1]){
            if (friends[i][0] in visitors){
                // visitors에서 삭제
                for (j in 0..visitors.size-1){
                    if (friends[i][0] == visitors[j]) {
                        selectedVisitors.remove(friends[i][0])
                    }
                }
            }
        }
    }

    for (i in 0 .. selectedVisitors.size-1){
        for (j in 0 .. friends_name_unique.size-1){
            if (selectedVisitors[i]==friends_name_unique[j]){
                score[j]++
            }
        }
    }

    // 높은 점수대로 정답을 담을 리스트
    val friendsScore = mutableListOf<String>()

    for (i in 0 .. score.size-1){
        // Max point를 찾는다
        val maxScore: Int = score.maxOrNull() ?: 0
        for (j in 0 .. score.size-1){
            if ( maxScore == score[j] && maxScore != 0){
                // max point 순서대로 추천 친구 수가 5명이 넘지 않았다면
                if (friendsScore.size < 6) {
                    // 리스트에 넣어준다
                    friendsScore.add(friends_name_unique[j])
                    // 중복 추가를 반복하지 않기위해 visited한 점수는 0으로 바꿔준다.
                    score[j] = 0
                }
            }
        }
    }

    return friendsScore
}
