package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val history = initHistory(forms)
    val uniqueUsers = getDuplicateUsers(history)
    val result = setToList(uniqueUsers)

    result.sort()
    return result
}

fun setToList(set: MutableSet<String>): MutableList<String> {
    val result = mutableListOf<String>()

    set.forEach {
        result.add(it)
    }

    return result
}

fun getDuplicateUsers(history: MutableMap<String, MutableSet<String>>): MutableSet<String> {
    val uniqueUsers = mutableSetOf<String>()

    history.forEach {
        if (it.value.size > 1) {
            it.value.forEach { email ->
                uniqueUsers.add(email)
            }
        }
    }

    return uniqueUsers
}

fun initHistory(forms: List<List<String>>): MutableMap<String, MutableSet<String>> {
    val history: MutableMap<String, MutableSet<String>> = mutableMapOf()

    for (form in forms) {
        val email = form[0]
        val nickname = form[1]

        val splittedResult = splitByTwo(nickname)

        for (result in splittedResult) {
            if(history[result] == null) {
                history[result] = mutableSetOf()
            }

            history[result]?.add(email)
        }
    }

    return history
}

fun splitByTwo(nickname: String): MutableList<String> {
    val result = mutableListOf<String>()

    for (i in 0 until nickname.length - 1) {
        result.add(nickname.substring(i, i + 2))
    }

    return result
}