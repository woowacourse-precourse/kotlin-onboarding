package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    val peopleSet = getPeopleSet(user, friends, visitors)
}

private fun getPeopleSet(user: String, friends: List<List<String>>, visitors: List<String>): MutableSet<String> {
    val peopleSet = mutableSetOf<String>()

    peopleSet.add(user)
    for (i in friends) peopleSet.addAll(i)
    peopleSet.addAll(visitors)

    return peopleSet
}
