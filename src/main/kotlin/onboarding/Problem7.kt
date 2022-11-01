package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val peopleSet = getPeopleSet(user, friends, visitors)
    val friendCandidateSet = excludeAlreadyFriendAndUser(peopleSet, user, friends)
    val friendSet = getFriendSet(user, friends)
    var candidateScoreMap = getCandidateScoreMap(friendCandidateSet)

    candidateScoreMap = calcMutualFriendScore(user, candidateScoreMap, friendSet, friends)
    candidateScoreMap = calcVisitorScore(candidateScoreMap, friendSet, visitors)

    return getSortedResult(candidateScoreMap)
}

private fun getPeopleSet(user: String, friends: List<List<String>>, visitors: List<String>): MutableSet<String> {
    val peopleSet = mutableSetOf<String>()

    peopleSet.add(user)
    for (i in friends) peopleSet.addAll(i)
    peopleSet.addAll(visitors)

    return peopleSet
}

private fun excludeAlreadyFriendAndUser(
    peopleSet: MutableSet<String>,
    user: String,
    friends: List<List<String>>
): MutableSet<String> {
    peopleSet.remove(user)
    for (i in friends) if (user in i) peopleSet.removeAll(i.toSet())

    return peopleSet
}

private fun getCandidateScoreMap(friendCandidateSet: MutableSet<String>): MutableMap<String, Int> {
    val candidateScoreMap = mutableMapOf<String, Int>()
    for (i in friendCandidateSet) candidateScoreMap[i] = 0

    return candidateScoreMap
}

private fun getFriendSet(user: String, friends: List<List<String>>): MutableSet<String> {
    val friendSet = mutableSetOf<String>()

    for (i in friends) if (user in i) friendSet.addAll(i)
    friendSet.remove(user)

    return friendSet
}

private fun calcMutualFriendScore(
    user: String,
    candidateScoreMap: MutableMap<String, Int>,
    friendSet: MutableSet<String>,
    friends: List<List<String>>
): MutableMap<String, Int> {
    for (i in friends) {
        for (j in i) {
            if (j in friendSet) {
                val candidatePerson = i.toMutableList()
                candidatePerson.remove(j)
                if (candidatePerson[0] != user && candidatePerson[0] !in friendSet) candidateScoreMap[candidatePerson[0]] =
                    candidateScoreMap[candidatePerson[0]]!! + 10
            }
        }
    }

    return candidateScoreMap
}

private fun calcVisitorScore(
    candidateScoreMap: MutableMap<String, Int>,
    friendSet: MutableSet<String>,
    visitors: List<String>
): MutableMap<String, Int> {
    for (i in visitors) if (i !in friendSet) candidateScoreMap[i] = candidateScoreMap[i]!! + 1

    return candidateScoreMap
}

private fun getSortedResult(candidateScoreMap: MutableMap<String, Int>): MutableList<String> {
    val candidateScoreList = candidateScoreMap.toList()
    var sortedCandidateScoreList = candidateScoreList.sortedWith(compareBy({ -it.second }, { it.first }))
    sortedCandidateScoreList = if (sortedCandidateScoreList.size < 5) {
        sortedCandidateScoreList.subList(0, sortedCandidateScoreList.size)
    } else {
        sortedCandidateScoreList.subList(0, 5)
    }

    val processedSortedCandidateScoreList = sortedCandidateScoreList.toMutableList()

    for (i in sortedCandidateScoreList) if (i.second == 0) processedSortedCandidateScoreList.remove(i)

    val resultList = mutableListOf<String>()

    for (i in processedSortedCandidateScoreList) resultList.add(i.first)

    return resultList
}
