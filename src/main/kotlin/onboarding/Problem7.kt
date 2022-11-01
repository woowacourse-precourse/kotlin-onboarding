package onboarding

fun solution7(
    user: String,
    friends: List<List<String>>,
    visitors: List<String>
): List<String> {
    TODO("프로그램 구현")
}

fun getUserList(friends: List<List<String>>, visitors: List<String>): List<String> {
    val userList: MutableList<String> = mutableListOf()

    for (i in friends) {
        if (!userList.contains(i[0])) {
            userList.add(i[0])
        }
        if (!userList.contains(i[1])) {
            userList.add(i[1])
        }
    }

    for (i in visitors) {
        if (!userList.contains(i)) {
            userList.add(i)
        }
    }

    return userList
}