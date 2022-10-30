package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    //TODO("프로그램 구현")

    val result = mutableListOf<String>()
    var index = 0

    index = getBaseCrew(forms)

    return result.distinct().sorted().toList()
}

fun getBaseCrew(forms: List<List<String>>): Int {
    var index = 0
    for (i in forms.indices) {
        if (forms[i][1].length >= 2) {
            index = i
            break
        }
    }
    return index
}