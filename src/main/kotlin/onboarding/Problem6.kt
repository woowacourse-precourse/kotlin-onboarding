package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val nicknameList = separateNickname(0, forms, arrayListOf())
    val letterList =  splitLetters(0, nicknameList, arrayListOf())
    val dulicatedLetterList = getDulicatedLetters(0, letterList, mutableSetOf())

    return getResult(0, mutableSetOf(), dulicatedLetterList, nicknameList)
}

fun separateNickname(
    index: Int,
    forms: List<List<String>>,
    nicknameList: ArrayList<Pair<String, String>>
): List<Pair<String, String>> {
    if (index == forms.size) {
        return nicknameList
    }
    val (email, nickname) = forms[index]
    nicknameList.add(Pair(email, nickname))
    return separateNickname(index + 1, forms, nicknameList)
}

fun splitLetters(
    index: Int,
    nicknameList: List<Pair<String, String>>,
    letterList: ArrayList<String>
) : List<String>  {
    if (index == nicknameList.size) {
        return letterList
    }
    val nickname = nicknameList[index].second
    getAllLetters(0, nickname, letterList)

    return splitLetters(index + 1, nicknameList, letterList)
}

fun getAllLetters(
    index: Int,
    nickName: String,
    letterList: ArrayList<String>
)  {
    if (index == nickName.length - 1) {
        return
    }
    val letter = nickName.substring(index, index + 2)
    letterList.add(letter)
    return getAllLetters(index + 1, nickName, letterList)
}

fun getDulicatedLetters(
    index : Int,
    letterList: List<String>,
    duplicatedLetterList : MutableSet<String>
) : Set<String> {
    if (index == letterList.size) {
        return duplicatedLetterList
    }

    val letter = letterList[index]
    letterList.count { it==letter }.apply {
        if (this >= 2) {
            duplicatedLetterList.add(letter)
        }
    }
    return getDulicatedLetters(index + 1, letterList, duplicatedLetterList)
}

fun getEmailList(
    index: Int,
    duplicatedLetter: String,
    emailResult: MutableSet<String>,
    nicknameList: List<Pair<String, String>>
) {
    if (index == nicknameList.size) {
        return
    }
    val nickname = nicknameList[index].second

    if (nickname.contains(duplicatedLetter)) {
        emailResult.add(nicknameList[index].first)
    }
    return getEmailList(index + 1, duplicatedLetter, emailResult,nicknameList)
}

fun getResult(
    index: Int,
    result: MutableSet<String>,
    duplicatedLetterList: Set<String>,
    nicknameList: List<Pair<String, String>>
): List<String> {
    if (index == duplicatedLetterList.size) {
        return result.sorted().toList()
    }
    getEmailList(0, duplicatedLetterList.elementAt(index), result, nicknameList)
    return getResult(index + 1, result, duplicatedLetterList, nicknameList)
}
