package onboarding

var nicknameList = arrayListOf<String>()
var emailList = arrayListOf<String>()
var letterList = arrayListOf<String>()
var duplicatedLetterList = mutableSetOf<String>()

fun solution6(forms: List<List<String>>): List<String> {
    nicknameList = arrayListOf()
    emailList = arrayListOf()
    letterList = arrayListOf()
    duplicatedLetterList = mutableSetOf()

    separateNickname(0, forms)
    splitLetters(0)
    val result = getResult(0, mutableSetOf())
    return result
}

fun separateNickname(index : Int, forms: List<List<String>>) {
    if (index == forms.size) {
        return
    }
    val (email, nickname) = forms[index]

    emailList.add(email)
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

fun getEmailList(index : Int, duplicatedLetter : String, emailResult : MutableSet<String>) {
    if (index == nicknameList.size) {
        return
    }
    val nickname = nicknameList[index]

    if (nickname.contains(duplicatedLetter)) {
        emailResult.add(emailList[index])
    }
    return getEmailList(index + 1, duplicatedLetter, emailResult)
}

fun getResult(index : Int, result: MutableSet<String>) : List<String> {
    if (index == duplicatedLetterList.size) {
        return result.sorted().toList()
    }
    getEmailList(0, duplicatedLetterList.elementAt(index), result)
    return getResult(index + 1, result)
}
