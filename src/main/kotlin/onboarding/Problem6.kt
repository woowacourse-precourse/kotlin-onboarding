package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val history = initHistory(forms)
}

fun initHistory(forms: List<List<String>>): MutableMap<String, MutableSet<String>> {
    val history: MutableMap<String, MutableSet<String>> = mutableMapOf()

    for (form in forms) {
        val email = form[0]
        val nickname = form[1]

        val splittedResult = splitByTwo(nickname)

        for (result in splittedResult) {
            history[result]?.add(email)
        }
    }

    return history
}

fun splitByTwo(nickname: String): MutableList<String> {
    val result = mutableListOf<String>()

    for (i in 0 until nickname.length - 1) {
        result.add(nickname.substring(i, i + 1))
    }

    return result
}