package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}
fun isKoreanNickname(nickname : String):Boolean{
    val nicknamePattern = "^[가-힣]*$"
    val pattern = Pattern.compile(nicknamePattern)
    val matcher = pattern.matcher(nickname)
    if(matcher.find()){
        return true
    }
    return false
}