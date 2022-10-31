package onboarding

/**
기능 목록
- 친구 관계 Map
- 친구 관계 Map으로 점수 10점씩 주기
- visitors List로 점수 1점씩 주기
- User와 User의 친구 점수 0점으로 초기화
- 조건대로 정렬, 개수 조절
- makeRelationMap: 친구 관계 Map 만드는 함수 (ex. relation["donut"] = "andole", relation["andole"] = "donut")
- makeScoreMapByRelationMap: relation Map으로 점수 Map 만드는 함수
- makeScoreMapByVisitorsList: visitors List로 점수 Map 만드는 함수
- exceptUserAndFriendsOfUser: User와 User의 친구에 대한 점수를 0점으로 초기화하는 함수
- refineScore: 점수가 0 초과이면서 점수가 높은 순, 점수가 같은 경우에는 이름순으로 정렬, 5개 이상인 경우 5개까지로 잘라서 List로 반환하는 함수
 */

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val relation = mutableMapOf<String, MutableSet<String>>()
    val score = mutableMapOf<String, Int>()

    makeRelationMap(friends, relation)
    makeScoreMapByRelationMap(relation, user, score)
    makeScoreMapByVisitorsList(visitors, relation, user, score)
    exceptUserAndFriendsOfUser(score, relation, user)

    return refineScore(score)
}

private fun makeRelationMap(friends: List<List<String>>, relation: MutableMap<String, MutableSet<String>>) {
    for (i in friends) {
        relation[i[0]]?.add(i[1]) ?: run {
            relation[i[0]] = mutableSetOf(i[1])
        }
        relation[i[1]]?.add(i[0]) ?: run {
            relation[i[1]] = mutableSetOf(i[0])
        }
    }
}

private fun makeScoreMapByRelationMap(
    relation: MutableMap<String, MutableSet<String>>,
    user: String,
    score: MutableMap<String, Int>
) {
    relation[user]?.forEach { userFriend ->
        relation[userFriend]?.forEach { friend ->
            score[friend] = score[friend]?.plus(10) ?: 10
        }
    }
}

private fun makeScoreMapByVisitorsList(
    visitors: List<String>,
    relation: MutableMap<String, MutableSet<String>>,
    user: String,
    score: MutableMap<String, Int>
) {
    for (i in visitors) {
        if (!relation.containsKey(user) || relation[user]?.contains(i) == false) {
            score[i] = score[i]?.plus(1) ?: 1
        }
    }
}

private fun exceptUserAndFriendsOfUser(
    score: MutableMap<String, Int>,
    relation: MutableMap<String, MutableSet<String>>,
    user: String
) {
    score.forEach { (key, _) ->
        if (relation[user]?.contains(key) == true || key == user) {
            score[key] = 0
        }
    }
}

private fun refineScore(map: MutableMap<String, Int>): List<String> {
    return map.toList()
        .sortedBy { it.first }
        .sortedByDescending { it.second }
        .filter { it.second > 0 }
        .map { it.first }
        .let {
            if (it.size > 5) it.subList(0, 5)
            else it
        }
}