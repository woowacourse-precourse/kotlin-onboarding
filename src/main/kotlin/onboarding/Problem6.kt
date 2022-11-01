package onboarding

import java.util.regex.Pattern

const val EMAIL = 0
const val NICKNAME = 1

fun solution6(forms: List<List<String>>): List<String> {
    checkThrowException(forms)
    return findDuplicateNickname(forms)
}

private fun checkThrowException(forms: List<List<String>>) {
    throwCrewNumberRangeException(forms)
    forms.forEach { crew ->
        throwEmailFormException(crew[EMAIL])
        throwEmailLengthException(crew[EMAIL])
        throwEmailDomainException(crew[EMAIL])
        throwNicknameFormException(crew[NICKNAME])
        throwNicknameLengthException(crew[NICKNAME])
    }
}

private fun throwCrewNumberRangeException(forms: List<List<String>>) {
    if (forms.size > 10_000 || forms.isEmpty()) throw error("크루는 1명 이상 10,000명 이하여야 합니다!")
}

private fun throwEmailFormException(email: String) {
    if (!Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$", email)) throw error("이메일 형식에 부합하지 않습니다!")
}

private fun throwEmailLengthException(email: String) {
    if (email.length >= 20 || email.length < 11) throw error("이메일 길이는 11자 이상 20자 미만이여야 합니다!")
}

private fun throwEmailDomainException(email: String) {
    if (!email.contains("@email.com")) throw error("신청할 수 있는 이메일은 email.com 도메인으로만 제한됩니다!")
}

private fun throwNicknameFormException(nickname: String) {
    if (!Pattern.matches("^[가-힣]*$", nickname)) throw error("닉네임은 한글만 가능합니다!")
}

private fun throwNicknameLengthException(nickname: String) {
    if (nickname.length >= 20 || nickname.isEmpty()) throw error("닉네임 길이는 1자 이상 20자 미만이어야 합니다!")
}

private fun findDuplicateNickname(forms: List<List<String>>): List<String> {
    val result = mutableListOf<String>()

    for (i in 0 until forms.size - 1) {
        for (j in 0 until forms[i][NICKNAME].length - 1) {
            val substring = forms[i][NICKNAME].substring(j, j + 2)
            for (k in i + 1 until forms.size) {
                if (forms[k][NICKNAME].contains(substring)) result.addAll(listOf(forms[i][EMAIL], forms[k][EMAIL]))
            }
        }
    }

    return result
        .distinct()
        .sorted()
}
