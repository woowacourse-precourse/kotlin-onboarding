package onboarding


fun solution6(forms: List<List<String>>): List<String> {
    val answer = mutableListOf<String>()

    for (i in forms.indices) {
        val email = forms[i][0]
        val nickname = forms[i][1]

        check(divideEmail(email = email).second.isDomainEmail()) {
            "$email email.com 도메인 형식을 지켜주세요."
        }
        check(email.length in 11..19) {
            "$email 이메일의 길이를 지켜주세요."
        }
        check(checkNicknameIsKr(nickname = nickname)) {
            "$nickname 이름의 형식을 지켜주세요."
        }

        // 닉네임이 1글자 이하라면 패스
        if (nickname.length <= 1) continue

        // 리스트의 다음 닉네임 부터 순회
        val exportStrList = exportStrList(nickname)
        for (j in i + 1 until forms.size) {
            val nextEmail = forms[j][0]
            val nextNickname = forms[j][1]
            exportStrList.forEach { findStr ->
                if (nextNickname.contains(findStr)) {
                    answer.add(nextEmail)
                    answer.add(email)
                }
            }
        }
    }

    // 중복제거 및 정렬
    return answer.distinct().sorted()
}

/** 닉네임이 한글인지, 1자 이상 20자 미만인지 체크한다. */
private fun checkNicknameIsKr(nickname: String): Boolean {
    val regex = Regex("^[가-힣]{1,20}$")
    return regex.matches(nickname)
}

/**
 * 닉네임에서 2개의 연속된 글자로 이루어진 리스트를 반환한다.
 * @return 예시) "평창보리" -> "평창", "창보", "보리"
 */
fun exportStrList(nickname: String): List<String> {
    val list = mutableListOf<String>()
    for (i in 0 until nickname.length - 1) {
        list.add(nickname[i].toString() + nickname[i + 1].toString())
    }
    return list.toList()
}

/**
 * '@'를 기준으로 도메인과 이메일로 나누어 반환하는 함수
 * @return first요소에 이메일, second요소에 도메인을 반환한다.
 */
fun divideEmail(email: String): Pair<String, String> {
    var idx = 0
    for (i in email) {
        if (i == '@') break
        idx += 1
    }
    return email.subSequence(0, idx).toString() to email.subSequence(idx + 1, email.length).toString()
}

/** 이메일의 도메인이 "email.com"인지 체크하는 함수 */
private fun String.isDomainEmail(): Boolean = this == "email.com"
