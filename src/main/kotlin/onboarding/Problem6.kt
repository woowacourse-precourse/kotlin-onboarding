package onboarding

//- 연속된 글자 추출 기능
//- 연속된 글자가 있는지 확인하는 기능
//- 이메일을 추출 하는 기능

const val NICKNAME_INDEX = 1
const val EMAIL_INDEX = 0
const val NEXT_NUMBER = 1
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

private fun findDuplicatesInList(
    separateNicknames: List<String>
): MutableSet<String> {
    val duplicateNicknames = mutableSetOf<String>()
    separateNicknames.map { separateNickname ->
        if (separateNicknames.indexOf(separateNickname) != separateNicknames.lastIndexOf(separateNickname))
            duplicateNicknames.add(separateNickname)
    }
    return duplicateNicknames
}