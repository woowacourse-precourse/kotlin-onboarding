package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val separateNicknameList = getSeparateNicknameList(forms)
    val duplicateNicknameList = mutableSetOf<String>()
    val duplicateNicknameEmailList = mutableListOf<String>()

    return duplicateNicknameEmailList.distinct().sorted()
}

private fun getSeparateNicknameList(forms: List<List<String>>):MutableList<String> {
    val separateNicknameList = mutableListOf<String>()
    for (i in forms.indices) {
        for(j in forms[i][1].indices) {
            if (j + 1 == forms[i][1].length) break
            separateNicknameList.add("${forms[i][1][j]}${forms[i][1][j + 1]}")
        }
    }
    return separateNicknameList
}

