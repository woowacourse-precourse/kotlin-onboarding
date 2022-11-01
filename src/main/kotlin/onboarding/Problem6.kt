
package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    if (isAppropriateForms(forms).isNotEmpty()) {
        return isAppropriateForms(forms)
    }

    val emails = HashSet<String>()
    val userMap: MutableMap<String, String> = HashMap()

    return listOf()
}

private fun isAppropriateForms(forms: List<List<String>>): List<String> {
    if (forms.isEmpty() || forms.size > 10000) {
        return listOf("크루가 1명 이상 10,000명 이하인지 체크해주세요.")
    }
    for (i in forms.indices) {
        val emailCheck = forms[i].first()
        val nicknameCheck = forms[i].last()

        if (emailCheck.length !in 11 until 20) {
            return listOf("이메일 전체 길이가 11자 이상 20자 미만인지 체크해주세요.")
        } else if (!emailCheck.contains("@email.com")) {
            return listOf("email.com 도메인을 포함하는지 체크해주세요.")
        } else if (nicknameCheck.length !in 1 until 20) {
            return listOf("닉네임 전체 길이가 1자 이상 20자 미만인지 체크해주세요.")
        }
    }
    return listOf()
}
