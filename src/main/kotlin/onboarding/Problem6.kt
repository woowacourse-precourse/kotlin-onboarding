package onboarding

fun setUserNickname(forms: List<List<String>>): String {
    var result = ""

    for(i in forms.indices - 1) {
        result += forms[i][1] + "_"
    }
    result += forms[forms.size - 1][1]

    return result
}

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableListOf<String>()

    val row = setUserNickname(forms)

    return result.toList()
}
