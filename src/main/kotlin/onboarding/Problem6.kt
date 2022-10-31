package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val answer = mutableListOf<String>()
    for (i in 0 until forms.size) {
        val email = forms[i][0]
        val nickname = forms[i][1]

        check(divideEmail(email = email).second.isDomainEmail()) {
            "$email email.com 도메인 형식을 지켜주세요."
        }
        check(email.length in 11..19) {
            "$email 이메일의 길이를 지켜주세요."
        }
        check(nickname.length in 1..19 && checkNicknameIsKr(nickname = nickname)) {
            "$nickname 이름의 형식을 지켜주세요."
        }

        // 닉네임이 1글자 이하라면 패스
        if (nickname.length <= 1) continue

        // 리스트의 다음 닉네임 부터 순회
        val exportStrList = exportStrList(nickname)
        for (j in i + 1 until forms.size) {
            val nextEmail = forms[i][0]
            val nextNickname = forms[j][1]
            exportStrList.forEach { findStr ->
                if (nextNickname.contains(findStr)) {
                    answer.add(nextEmail)
                    answer.add(nextEmail)
                }
            }
        }
    }

    // 중복제거 및 정렬
    return sortEmailByAesc(emailDuplicateCheck(answer))
}

/** 닉네임이 한글인지 체크한다. */
private fun checkNicknameIsKr(nickname: String): Boolean {
    for (i in nickname) {
        if (i.code < '가'.code || i.code > '힣'.code) return false
    }
    return true
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
    for (i in 0 until email.length) {
        if (email[i] == '@') break
        idx += 1
    }
    return email.subSequence(0, idx).toString() to email.subSequence(idx + 1, email.length).toString()
}

/**
 * 기존문자열에서 파라미터로 온 2글자의 문자열을 포함하는지 체크한다.
 * 2글자 이상의 파라미터 문자열 및 기본 문자열만 체크한다.
 */
fun String.contains(findStr: String): Boolean {
    if (this.length <= 1 && findStr.length <= 1) {
        return false
    }
    for (i in 0 until this.length - 1) {
        if ((this[i].toString() + this[i + 1].toString()) == findStr) {
            return true
        }
    }
    return false
}

/** 이메일의 도메인이 "email.com"인지 체크하는 함수 */
private fun String.isDomainEmail(): Boolean = this == "email.com"

/**
 * 이메일 리스트를 이메일에 해당하는 부분의 문자열 기준으로
 * 오름차순으로 정렬하여 반환한다.
 */
fun sortEmailByAesc(emailList: List<String>): List<String> {
    val emailList = ArrayList(emailList.map {
        divideEmail(it).first
    })
    // 버블 정렬
    for (i in 0 until emailList.size) {
        for (j in i until emailList.size - 1) {
            if (emailList[i] > emailList[j]) {
                val temp = emailList[j]
                emailList[j] = emailList[i]
                emailList[i] = temp
            }
        }
    }
    return emailList.map {
        "$it@email.com"
    }.toList()
}

/** 리스트에 중복된 이메일을 제거한다. */
fun emailDuplicateCheck(emailList: List<String>): List<String> {
    val pureList = mutableListOf<String>()
    for (i in 0 until emailList.size) {
        pureList.add(emailList[i])
        for (j in i + 1 until emailList.size) {
            if (pureList.contains(emailList[j])) {
                pureList.removeAt(pureList.lastIndex)
                break
            }
        }
    }
    return pureList
}