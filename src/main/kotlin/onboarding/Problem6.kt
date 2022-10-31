package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}


/**
 * @를 기준으로 도메인과 이메일로 나누어 반환하는 함수
 * first요소에 이메일, second요소에 도메인을 반환한다.
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
    check(this.length > 1 && findStr.length > 1) {
        return false
    }
    for (i in 0 until this.length - 1) {
        if ((this[i].toString() + this[i + 1].toString()) == findStr) {
            return true
        }
    }
    return false
}

/**
 * 이메일의 도메인이 "email.com"인지 체크하는 함수
 */
fun String.isEmailDomain(): Boolean {

}

/**
 * 이메일 리스트를 이메일에 해당하는 부분의 문자열 기준으로
 * 오름차순으로 정렬하여 반환한다.
 */
fun sortEmailByAesc(emailList: List<String>): List<String> {

}

/**
 * 리스트에 중복된 이메일이 있는지 체크 및 제거
 */
fun emailDuplicateCheck(emailList: List<String>): List<String> {

}

