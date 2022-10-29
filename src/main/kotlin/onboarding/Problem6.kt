package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = ArrayList<String>()
    for (i in forms.indices) {
        val othersForms = forms.toMutableList()
        othersForms.remove(forms[i])

        if (divideNickname(forms[i][1], othersForms)) {
            result.add(forms[i][0])
        }
    }
    result.sort()

    return result
}

fun divideNickname(nickname: String, othersForms: List<List<String>>): Boolean {
    if (nickname.length <= 2) {
        if (nicknameCheck(nickname, othersForms)) {
            return true
        }
        return false
    }
    for (i in 0..nickname.length - 2) {
        val twoWord = nickname.substring(i, i + 2)
        if (nicknameCheck(twoWord, othersForms)) {
            return true
        }
    }
    return false
}

fun nicknameCheck(twoWord: String, othersForms: List<List<String>>): Boolean {
    for (i in othersForms.indices) {
        if (othersForms[i][1].contains(twoWord)) {
            return true
        }
    }
    return false
}
