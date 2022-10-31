package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}
fun isCompareWard(name1: String, name2: String): Boolean {
    var result: Boolean = false
    for (i in 0..name1.length - 2) {
        var compareWard: String = name1.substring(i, i + 2)
        if (name2.contains(compareWard)) {
            result = true
        }
    }
    return result
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
fun isNicknameLength(nickname: String):Boolean{
    if(nickname.length in 1.. 19){
        return true
    }
    return false
}
fun isEmailLength(email: String): Boolean {
    if (email.length in 11..19) {
        return true
    }
    return false
}