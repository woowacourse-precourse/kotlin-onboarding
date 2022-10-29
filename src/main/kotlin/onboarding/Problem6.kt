package onboarding

import java.util.regex.Pattern


const val DOMAIN = "@email.com"

fun emailLength(email: String): Boolean {
    return email.length in 11 until 20
}

fun nickNameLength(nickname: String): Boolean {
    return nickname.length in 1 until 20
}

fun correctLength(email: String, nickname: String): Boolean {
    return emailLength(email) && nickNameLength(nickname)
}

fun correctDomain(email: String): Boolean {
    return email.contains(DOMAIN)
}
fun correctNickName(nickname: String): Boolean {
    val pattern = Pattern.compile("^[ㄱ-ㅣ가-힣]+$")
    return pattern.matcher(nickname).matches()
}

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}