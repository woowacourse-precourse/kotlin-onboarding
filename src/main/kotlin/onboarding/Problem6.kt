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

fun getWordsList(forms: List<List<String>>): Array<HashSet<String>> {
    val list = Array(forms.size) { HashSet<String>() }

    for(i in forms.indices) {
        list[i] = getTwoLetterWordsSet(forms[i][1])
    }
    return list
}

fun getTwoLetterWordsSet(nickName: String): HashSet<String> {
    val words = HashSet<String>()

    for(i in 0 until nickName.length-1) {
        words.add(nickName.substring(i..i+1))
    }
    return words
}
