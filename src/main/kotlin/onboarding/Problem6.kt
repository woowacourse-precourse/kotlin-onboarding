@file:Suppress("UNREACHABLE_CODE")

package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {

    TODO("프로그램 구현")
}



fun isDuplicatedNickName(nickName1: String, nickName2: String) : Boolean {
    var isDuplicated = true
    for (i in nickName1.indices) {
        var subName = nickName1.substring(i, i + 1)
        if (nickName2.contains(subName))
            isDuplicated = true
    }
    return isDuplicated
}


fun checkedEmailForm(email: String): Boolean {
    val emailForm = "@email.com"
    return emailForm == email.substring(email.length - 9, email.length) && email.length in 11..19
}

fun checkedNickNameLength(nickName: String): Boolean {
    return nickName.length in 1..19
}

fun isKoreanNickName(nickName: String): Boolean {
    val pattern = Pattern.compile("^[가-힣]*$")
    return pattern.matcher(nickName).find()
}





