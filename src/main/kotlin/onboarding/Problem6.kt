package onboarding
/*
    기능 목록
    1. 이메일 유효성 검사하는 함수 isValidEmail
    2. 닉네임 유효성 검사하는 함수 isValidNickName
    3. 닉네임 중복 체크하는 함수 checkNickName

 */

fun solution6(forms: List<List<String>>): List<String> {
    var result = forms.filter { it -> isValidEmail(it[0]) && isValidNickName(it[1]) }
    // 이메일 검사, 닉네임도 같이 검사해야할듯
    forms.filter { it -> isValidEmail(it[0]) && isValidNickName(it[1]) }
    // 닉네임 중복 체크
    checkNickName(result).sortedBy { it.toString() }
    // 이메일 정렬
    return checkNickName(result).sortedBy { it }
}

fun isValidEmail(email: String): Boolean = "[A-Za-z]*(@email.com)$".toRegex()
    .matches(email)
