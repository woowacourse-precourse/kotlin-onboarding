package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    checkForms(forms)

    val result = mutableListOf<String>()

    for (i in 0 until forms.size - 1) {
        val crew = forms[i]
        val nickName = crew[1]

        for (j in 0 until nickName.length - 1) {
            val substring = nickName.substring(j, j + 2)

            for (k in i + 1 until forms.size) {
                if (forms[k][1].contains(substring)) {
                    result.addAll(listOf(forms[i][0], forms[k][0]))
                }
            }
        }
    }

    return result
        .distinct()
        .sorted()
}


fun checkForms(forms: List<List<String>>) {
    require(forms.size in 1..10000) { "크루는 1명 이상 10,000명 이하이다." }
    forms.onEach { crew ->
        checkEmail(crew)
        checkNickName(crew)
    }
}

fun checkEmail(crew: List<String>) {
    val emailAddress = crew[0]
    require(Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$", emailAddress)) { "이메일은 이메일 형식에 부합해야한다." }
    require(emailAddress.length in 11 until 21) { "이메일의 전체 길이는 11자 이상 20자 미만이다." }
    require(emailAddress.contains("@email.com")) { "신청할 수 있는 이메일은 email.com 도메인으로만 제한한다." }
}

fun checkNickName(crew: List<String>) {
    val nickName = crew[1]
    require(Pattern.matches("^[가-힣]*$", nickName)) { "닉네임은 한글만 가능하고" }
    require(nickName.length in 1 until 20) { "전체 길이는 1자 이상 20자 미만이다." }
}
