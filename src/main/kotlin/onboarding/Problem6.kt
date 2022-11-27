package onboarding

const val NICKNAME_INDEX = 1
const val EMAIL_INDEX = 0
const val NEXT_NUMBER = 1
const val MAXIMUM_HEADCOUNT = 10000
const val EMAIL_ERROR ="이메일 형식에 맞지 않는 회원이 있습니다."
const val NICKNAME_ERROR = "닉네임 형식에 맞지 않는 회원이 있습니다."
const val OVER_CREW_RANGE ="크루 인원수가 10000명 초과입니다"

private val EMAIL_FORM = "^[A-Za-z0-9._-]{1,9}@email.com\$".toRegex()
private val NICKNAME_FORM = "^[ㄱ-힣]{1,19}\$".toRegex()
fun solution6(forms: List<List<String>>): List<String> {
    exceptionForm(forms)
    val separateNicknameList = getSeparateNicknames(forms)
    val duplicateNicknameList = findDuplicatesInSeparateNicknames(separateNicknameList)
    return getDuplicateNicknameEmails(forms, duplicateNicknameList)
}

fun exceptionForm(forms: List<List<String>>) {
    forms.forEach { userInfo ->
        require(isEmailForm(userInfo[EMAIL_INDEX])) { println(EMAIL_ERROR) }
        require(isNickNameForm(userInfo[NICKNAME_INDEX])) { println(NICKNAME_ERROR) }
        require(isCrewHeadCountRange(forms)) { println(OVER_CREW_RANGE) }
    }
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

private fun isCrewHeadCountRange(forms: List<List<String>>): Boolean = forms.size <= MAXIMUM_HEADCOUNT
