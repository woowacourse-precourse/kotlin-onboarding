package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val separateNicknameList = getSeparateNicknameList(forms)
    val duplicateNicknameList = getDuplicateNicknameList(separateNicknameList)
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
private fun getDuplicateNicknameList(
    separateNicknameList:MutableList<String>
):MutableSet<String> {
    val duplicateNicknameList = mutableSetOf<String>()
    for(i in separateNicknameList.indices) {
        if(separateNicknameList.indexOf(separateNicknameList[i]) !=separateNicknameList.lastIndexOf(separateNicknameList[i]))
            duplicateNicknameList.add(separateNicknameList[i])
    }
    return duplicateNicknameList
}

