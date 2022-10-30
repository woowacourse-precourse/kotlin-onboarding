package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result = forms.filter { it -> isValidEmail(it[0]) && isValidNickName(it[1]) }
    // 이메일 검사, 닉네임도 같이 검사해야할듯
    forms.filter { it -> isValidEmail(it[0]) && isValidNickName(it[1]) }
    // 닉네임 중복 체크
    checkNickName(result).sortedBy { it.toString() }
    println(checkNickName(result).sortedBy { it })
    // 이메일 정렬
    return checkNickName(result).sortedBy { it }
}

fun isValidEmail(email: String): Boolean = "[A-Za-z]*(@email.com)$".toRegex().matches(email)
fun isValidNickName(nickName: String): Boolean = "[가-힣]{1,19}".toRegex().matches(nickName)

fun checkNickName(forms: List<List<String>>): List<String> {
    val resultList = mutableSetOf<String>()
    for (i in forms) {
        var window = i[1].split("").windowed(2).map { it.joinToString("") }.filter { it.length == 2 }
        for (j in forms) {
            if (i == j) continue
            window.forEach {
                if (j[1].contains(it)) {
                    resultList += j[0]
                }
            }
        }
    }
    return resultList.toList()
}