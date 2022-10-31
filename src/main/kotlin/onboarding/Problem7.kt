package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val peopleSet = getPeopleSet(user, friends, visitors)
    val friendCandidateSet = excludeAlreadyFriendAndUser(peopleSet, user, friends)
    val candidateScoreMap = getCandidateScoreMap(friendCandidateSet)
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
