package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val separateNicknameList = mutableListOf<String>()
    val duplicateNicknameList = mutableSetOf<String>()
    val duplicateNicknameEmailList = mutableListOf<String>()
    for (i in forms.indices) {
        for(j in forms[i][1].indices) {
            if (j + 1 == forms[i][1].length) break
            separateNicknameList.add("${forms[i][1][j]}${forms[i][1][j + 1]}")
        }
    }
    for(i in separateNicknameList.indices) {
        if(separateNicknameList.indexOf(separateNicknameList[i]) !=separateNicknameList.lastIndexOf(separateNicknameList[i])) duplicateNicknameList.add(separateNicknameList[i])
    }
    for(i in forms.indices) {
        for(j in duplicateNicknameList) {
            if(forms[i][1].indexOf(j)!=-1) {
                duplicateNicknameEmailList.add(forms[i][0])
                break
            }
        }
    }
    return duplicateNicknameEmailList.distinct().sorted()
}
