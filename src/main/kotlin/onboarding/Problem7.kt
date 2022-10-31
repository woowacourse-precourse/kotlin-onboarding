package onboarding

import java.util.Collections

// 기능 목록
// 1. 맵 자료구조를 활용하여 친구목록을 정리하는 메소드 구현
// 2. 친구를 매개변수로 받아 추천 점수를 계산하는 메소드 구현
// 3. 이미 친구인 사람을 제외 하고 추천 점수의 우열을 가려 최대 5명 정답리스트에 추가
// 4. 만약 추천 점수가 같다면 이름순으로 정렬하여 리턴

private val friendsMap: MutableMap<String, String> = HashMap()
private val recommendedFriendsSet = HashSet<String>()
private val recommendScoreMap: MutableMap<String, Int> = HashMap()
fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    makeFriendsMap(friends)
    TODO("리턴 값 미구현")
}

// 기능 목록 1번
fun makeFriendsMap(friends: List<List<String>>) {
    for (friendlyRelations in friends) {
        val friend1 = friendlyRelations[0]
        val friend2 = friendlyRelations[1]

        if (friendsMap.containsKey(friend1)) {
            if (!friendsMap[friend1]!!.contains(friend2)) {
                friendsMap[friend1] += ".$friend2"
            }
        }
        if (!friendsMap.containsKey(friend1)) {
            friendsMap[friend1] = friend2
        }

        if (friendsMap.containsKey(friend2)) {
            if (!friendsMap[friend2]!!.contains(friend1)) {
                friendsMap[friend2] += ".$friend1"
            }
        }
        if (!friendsMap.containsKey(friend2)) {
            friendsMap[friend2] = friend1
        }
    }
}

// 기능 목록 2번
fun calculateRecommendScore(user: String, checkForName: String, visitors: List<String>): Int {
    var score = 0
    // 친구는 아닌데 방문만 한경우
    if (!friendsMap.containsKey(checkForName)) {
        score = Collections.frequency(visitors, checkForName)
        return score
    }

    // 이미 친구인 경우
    if (friendsMap[user]!!.contains(checkForName)) {
        return 0
    }

    // 친구는 아니고 추천 점수를 계산해야하는 경우 , 내친구 목록과 타겟 친구 목록을 서로 비교 같은게 있으면
    score += Collections.frequency(visitors, checkForName)
    val userFriends = friendsMap[user]!!.split(".")
    val checkForNameFriends = friendsMap[checkForName]!!.split(".")

    val intersectFriends = userFriends.toSet().intersect(checkForNameFriends.toSet())
    score += intersectFriends.size * 10

    return score

}
