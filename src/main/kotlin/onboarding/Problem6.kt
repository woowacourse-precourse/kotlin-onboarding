package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val separateNicknameList = getSeparateNicknameList(forms)
    val duplicateNicknameList = findDuplicatesInList(separateNicknameList)
    val duplicateNicknameEmailList = mutableListOf<String>()
    return duplicateNicknameEmailList.distinct().sorted()
}

private fun getSeparateNicknameList(forms: List<List<String>>):MutableList<String> {
    val list = mutableListOf<String>()
    for (i in forms.indices) {
        for(j in forms[i][1].indices) {
            if (j + 1 == forms[i][1].length) break
            list.add("${forms[i][1][j]}${forms[i][1][j + 1]}")
        }
    }
    return list
}
private fun findDuplicatesInList (
    list:List<String>
):MutableSet<String> {
    var returnList:MutableSet<String> = mutableSetOf<String>()
    for(i in list.indices) {
        if(list.indexOf(list[i]) !=list.lastIndexOf(list[i])) returnList.add(list[i])
    }
    return returnList
}



