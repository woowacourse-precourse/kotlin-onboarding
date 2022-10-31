package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val twoLetterNameSetList = setTwoLetterNameSetList(forms)
    return emptyList()
}

// 각 유저마다 2글자씩 분리한 Set 생성
fun getTwoLetterNameSet(userNameList: List<String>): MutableSet<String> {
    val twoLetterNameSet = mutableSetOf<String>()
    val userNickname = userNameList[1]
    for (alphabetIdx in 0 until userNickname.lastIndex) {
        val twoLetterName = "${userNickname[alphabetIdx]}${userNickname[alphabetIdx + 1]}"
        twoLetterNameSet.add(twoLetterName)
    }
    return twoLetterNameSet
}

fun setTwoLetterNameSetList(forms: List<List<String>>): MutableList<MutableSet<String>> {
    val twoLetterNameSetList = mutableListOf<MutableSet<String>>()
    for (user in forms) {
        val twoLetterNameSet = getTwoLetterNameSet(user)
        twoLetterNameSetList.add(twoLetterNameSet)
    }

    return twoLetterNameSetList
}