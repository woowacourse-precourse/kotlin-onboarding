package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = arrayListOf<String>()
    val wordsList = getWordsList(forms)

    for(i in forms.indices) {
        if(isDuplicatedNickname(i, wordsList)) {
            result.add(forms[i][0])
        }
    }

    result.sort()
    return result
}

fun isDuplicatedNickname(index: Int, wordsList: Array<HashSet<String>>): Boolean {
    for(i in wordsList.indices) {
        if(index != i && wordsList[index].any { wordsList[i].contains(it) }) {
            return true
        }
    }
    return false
}


