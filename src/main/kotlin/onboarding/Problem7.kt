package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {

    val relation = mutableMapOf<String, MutableSet<String>>()
    val score = mutableMapOf<String, Int>()

    makeRelationMap(friends, relation)
    makeScoreMapByFriendsList(relation, user, score)
    makeScoreMapByVisitorsList(visitors, relation, user, score)
    exceptUserAndFriendsOfUser(score, relation, user)

    return refineScore(score)
}

private fun makeRelationMap(friends: List<List<String>>, relation: MutableMap<String, MutableSet<String>>) {
    for (i in friends) {
        if (relation.containsKey(i[0])) relation[i[0]]!!.add(i[1])
        else relation[i[0]] = mutableSetOf(i[1])
        if (relation.containsKey(i[1])) relation[i[1]]!!.add(i[0])
        else relation[i[1]] = mutableSetOf(i[0])
    }
}

private fun makeScoreMapByFriendsList(
    relation: MutableMap<String, MutableSet<String>>,
    user: String,
    score: MutableMap<String, Int>
) {
    relation[user]?.forEach { userFriend ->
        relation[userFriend]?.forEach { friend ->
            if (score.containsKey(friend)) score[friend] = score[friend]!!.plus(10)
            else score[friend] = 10
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
            if (score.containsKey(i)) {
                score[i] = score[i]!!.plus(1)
            } else score[i] = 1
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