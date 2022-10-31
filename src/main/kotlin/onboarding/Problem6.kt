package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    var regularForms = mutableListOf<List<String>>()
    var resultForms = mutableSetOf<List<String>>()
    var result = mutableListOf<String>()

    for (i in 0..forms.size - 1) {
        if (isEmailLength(forms[i][0])&& isKoreanNickname(forms[i][1]) && isNicknameLength(forms[i][1])) {
            regularForms.add(forms[i])
        }
    }
    for (i in 0..regularForms.size - 1) {
        for (j in 0..regularForms.size - 1) {
            if (i != j) {
                if (isCompareWard(regularForms[i][1], regularForms[j][1])) {
                    resultForms.add(regularForms[i])
                    resultForms.add(regularForms[j])
                }
            }
        }
    }
    for (element in resultForms) {
        result.add(element[0])
    }
    result.sort()
    return result
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