package onboarding

//- 연속된 글자 추출 기능
//- 연속된 글자가 있는지 확인하는 기능
//- 이메일을 추출 하는 기능

const val NICKNAME_INDEX = 1
const val EMAIL_INDEX = 0
const val NEXT_NUMBER = 1
const val MAXIMUM_HEADCOUNT = 10000

private val EMAIL_FORM = "^[A-Za-z0-9._-]{1,9}@email.com\$".toRegex()
private val NICKNAME_FORM = "^[ㄱ-힣]{1,19}\$".toRegex()
fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

private fun getSeparateNicknames(forms: List<List<String>>): MutableList<String> {
    val list = mutableListOf<String>()
    forms.map { userInfo ->
        for (index in userInfo[NICKNAME_INDEX].indices) {
            if (index + NEXT_NUMBER == userInfo[NICKNAME_INDEX].length) break
            list.add("${userInfo[NICKNAME_INDEX][index]}${userInfo[NICKNAME_INDEX][index + NEXT_NUMBER]}")
        }
    }
    return list
}

private fun findDuplicatesInSeparateNicknames(
    separateNicknames: List<String>
): MutableSet<String> {
    val duplicateNicknames = mutableSetOf<String>()
    separateNicknames.map { separateNickname ->
        if (separateNicknames.indexOf(separateNickname) != separateNicknames.lastIndexOf(separateNickname))
            duplicateNicknames.add(separateNickname)
    }
    return duplicateNicknames
}

private fun getDuplicateNicknameEmails(
    forms: List<List<String>>,
    duplicateNicknames: MutableSet<String>
): List<String> {
    val duplicateNicknameEmails = mutableListOf<String>()
    forms.map { userInfo ->
        for (duplicateNickname in duplicateNicknames) {
            if (userInfo[NICKNAME_INDEX].indexOf(duplicateNickname) != -1) {
                duplicateNicknameEmails.add(userInfo[EMAIL_INDEX])
                break
            }
        }
    }
    return duplicateNicknameEmails.distinct().sorted()
}

// 조성록 개발자님 코드 참고 (우테코 덕분에 많이 배웁니다.)
private fun isEmailForm(email: String): Boolean = EMAIL_FORM.matches(email)

private fun isNickNameForm(nickname: String): Boolean = NICKNAME_FORM.matches(nickname)

private fun isCrewHeadCountRange(forms: List<List<String>>): Boolean = forms.isNotEmpty() && forms.size <= MAXIMUM_HEADCOUNT
