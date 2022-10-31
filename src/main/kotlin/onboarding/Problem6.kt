package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {

    if (!validCheck(forms)){
        return (listOf("Invalid"))
    }
    val result = mutableListOf<String>()
    val crewInfoMap = mutableMapOf<String, String>()
    val nicknameSet = mutableSetOf<String>()

    forms.forEach { crewInfo ->
        crewInfoMap.keys.forEach { nickname ->
            if (checkDuplicateNickname(crewInfo[1], nickname)) {
                nicknameSet.add(nickname)
                nicknameSet.add(crewInfo[1])
            }
        }
        crewInfoMap[crewInfo[1]] = crewInfo[0]
    }

    result.run {
        addAll(nicknameSet.mapNotNull { nickname -> crewInfoMap[nickname] })
        sort()
    }

    return result.toList()
}

private fun validCheck(forms: List<List<String>>): Boolean {

    var result = true

    if (forms.size !in 1..10000) {
        result = false
    }

    else if (!checkValiedEmail(forms)) {
        result = false
    }

    else if (!checkValidNickname(forms)) {
        result = false
    }

    return result
}

private fun checkValidNickname(forms: List<List<String>>): Boolean {

    for (crew in forms) {
        if (!Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$", crew[1]))
            return false
    }

    return true
}

private fun checkValiedEmail(forms: List<List<String>>): Boolean {

    for (crew in forms) {

        if (!Pattern.matches("^[a-zA-Z0-9]{1,9}+@email.com$", crew[0]))
            return false

    }

    return true
}

private fun checkDuplicateNickname(nickname_1: String, nickname_2: String): Boolean {
    for (i in 0 until nickname_1.length - 1) {
        if (nickname_2.contains(nickname_1.substring(i, i + 2))) {
            return true
        }
    }
    return false
}