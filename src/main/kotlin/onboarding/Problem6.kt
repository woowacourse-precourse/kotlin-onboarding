package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var order = 1
    var result = mutableSetOf<String>()

    forms.forEach { crewInfo ->
        val splitWords = splitNicknameIntoWords(crewInfo[1])
        val emailWithDuplicatedWord = checkDuplication(forms, order++, splitWords)

        if (emailWithDuplicatedWord.isNotEmpty()) {
            result.add(crewInfo[0])
            result.add(emailWithDuplicatedWord)
        }
    }

    return result.sorted().toList()
}

fun splitNicknameIntoWords(nickname: String) : MutableSet<String> {
    val nicknameList = mutableSetOf<String>()

    for (j in 2 until nickname.length + 1) {
        for (i in nickname.indices) {
            if (j + i <= nickname.length) {
                nicknameList.add(nickname.substring(i, i + j))
            }
        }
    }

    return nicknameList
}


fun checkDuplication(
    forms: List<List<String>>,
    order: Int,
    splitWords: MutableSet<String>)
: String {
    for (i in order until forms.size) {
        splitWords.forEach { nn ->
            if (forms[i][1].contains(nn)) {
                return forms[i][0]
            }
        }
    }
    return ""
}