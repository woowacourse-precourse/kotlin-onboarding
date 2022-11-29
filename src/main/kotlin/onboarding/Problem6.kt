package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    val mCrewList = removeExceptedCrew(forms)
    val mEmailList = mutableListOf<String>() // 리턴해줄 이메일을 담을 배열
    for (i in mCrewList.indices) {
        mEmailList += getTargetWords(i, mCrewList[i], mCrewList)
    }
    return returnProcessing(mEmailList)
}

private fun removeExceptedCrew(forms: List<List<String>>): MutableList<List<String>> {
    for (i in forms.indices) {
        if (!checkException(forms[i])) { //예외사항에 부합될 시에만 실행됨
            forms.toMutableList().removeAt(i)
        }
    }
    return forms.toMutableList()
}

private fun getTargetWords(loop1: Int, list: List<String>, forms: List<List<String>>): List<String> {
    val matchedNameList = mutableListOf<String>()
    for (o in list[1].indices) {
        matchedNameList += checkNicknameWithTargetWords(loop1, getWord(o, list[1]), forms)
    }
    return matchedNameList
}

private fun checkNicknameWithTargetWords(loop1: Int, word: String?, list: List<List<String>>): MutableList<String> {
    val matchedNameList = mutableListOf<String>()
    for (u in list.indices) {
        if (checkAvailable(word, list[u][1]) && loop1 != u) {
            matchedNameList.add(list[u][0])
        }
    }
    return matchedNameList
}

/**
 * 에외사항을 최종 종합해서 리턴해주는 함수
 */
private fun checkException(crew: List<String>): Boolean {
    return checkEmailRegex(crew[0]) && checkNameRegex(crew[1])
}

/**
 * 이메일 예외사항 (이메일 형식 -> email.com), 길이 (11자 이상 20자 미만) 인지를 판단 후 T/F값 리턴
 */
private fun checkEmailRegex(email: String): Boolean {
    return email.contains("email.com") && email.length in 11 until 20
}

/**
 * 닉네임 예외사항 (한글로만 구성되어있는지), 길이 (1자 이상 20자 미만) 인지를 판단 후 T/F값 리턴
 */
private fun checkNameRegex(name: String): Boolean {
    return Pattern.matches("^[가-힣]*$", name) && name.length in 1 until 20
}

/**
 * 현재 닉네임에서 중복 검사할 문자 (2글자 이상 똑같다면 중복으로 판단하므로, 2글자싹만 리턴) 리턴
 */
private fun getWord(index: Int, name: String): String? {
    return if (name.length > index + 1) {
        name.substring(index..index + 1) //현재 넘겨준 인덱스 (이 이름의 몇 번째 인덱스부터 시작할지) 와 그보다 한 글자 더, 즉 2글자만 리턴
    } else null
}

/**
 * 크루들 닉네임을 돌면서 중복 판단할 문자열이 존재하는지 여부 T/F 반환
 */
private fun checkAvailable(word: String?, crewInfo: String): Boolean {
    return word != null && crewInfo.contains(word)
}

/**
 * 리턴할 이메일 배열의 중복 제거 및 정렬하는 함수
 */
private fun returnProcessing(list: List<String>): List<String> {
    return list.distinct().sorted()
}