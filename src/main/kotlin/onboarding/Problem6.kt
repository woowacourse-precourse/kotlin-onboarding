package onboarding

import org.mockito.internal.matchers.Null

fun solution6(forms: List<List<String>>): List<String> {

    val regularForms = checkEmailAndNickname(forms)

}

fun checkEmailAndNickname(forms: List<List<String>>): List<List<String>>{
    val regularForms = mutableListOf<List<String>>()
    for(i in forms.indices){
        if(forms[i][0].length in 11 until 20 && forms[i][0].contains("@email.com")
            && forms[i][0].length in 1 until 20 && isKorean(forms[i][1])){
            regularForms.add(forms[i])
        }
    }
    return regularForms
}

fun isKorean(nickname: String): Boolean {
    for(i in nickname.indices){
        val char = nickname.codePointAt(i)
        if (char < 0xAC00 || char > 0xD800)
            return false
    }
    return true
}