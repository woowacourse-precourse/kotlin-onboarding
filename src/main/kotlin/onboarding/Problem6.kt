package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    //TODO("프로그램 구현")

    val result = mutableListOf<String>()
    var index = 0

    index = getBaseCrew(forms)

    for (i in 0 until forms[index][1].length-1) {
        val check = forms[index][1].substring(i, i+2)
        result.addAll(searchDuplicatedCrew(forms, check))
    }

    return result.distinct().sorted().toList()
}

fun searchDuplicatedCrew(forms: List<List<String>>, checkString: String): List<String> {
    val duplicatedCrew = mutableListOf<String>()
    for (element in forms) {
        if (element[1].contains(checkString)) {
            duplicatedCrew.add(element[0])
        }
    }
    return duplicatedCrew
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