package onboarding

val nicknameList = arrayListOf<String>()
val form = mutableMapOf<String, String>()
val letterList = arrayListOf<String>()
val duplicatedLetterList = mutableSetOf<String>()

fun solution6(forms: List<List<String>>): List<String> {
    separateNickname(0, forms)
    splitLetters(0)

    return getResult(0, arrayListOf())
}

fun separateNickname(index : Int, forms: List<List<String>>) : Map<String, String> {
    if (index == forms.size) {
        return form
    }
    val (email, nickname) = forms[index]

    form.put(nickname, email)
    nicknameList.add(nickname)
    return separateNickname(index + 1, forms)
}

fun splitLetters(index : Int) {
    if (index == nicknameList.size) {
        return
    }
    val nickname = nicknameList[index]

    getDulicatedLetters(0, nickname)
    return splitLetters(index + 1)
}

fun getDulicatedLetters(index : Int, nickName : String) : Set<String> {
    if (index == nickName.length - 1) {
        return duplicatedLetterList
    }
    val letter = nickName.substring(index, index + 2)

    if (letterList.contains(letter)) {
        duplicatedLetterList.add(letter)
    }
    letterList.add(letter)
    return getDulicatedLetters(index + 1, nickName)
}

fun getEmailList(index : Int, duplicatedLetter : String, email : ArrayList<String>) {
    if (index == nicknameList.size) {
        return
    }
    val nickname = nicknameList[index]

    if (nickname.contains(duplicatedLetter)) {
        form[nickname]?.let { email.add(it) }
    }
    return getEmailList(index + 1, duplicatedLetter, email)
}

fun getResult(index : Int, result: ArrayList<String>) : List<String> {
    if (index == duplicatedLetterList.size) {
        return result.sorted().toList()
    }
    getEmailList(0, duplicatedLetterList.elementAt(0), result)
    return getResult(index + 1, result)
}
