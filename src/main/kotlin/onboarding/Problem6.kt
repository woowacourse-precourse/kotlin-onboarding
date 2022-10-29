package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    val mCrewList = forms.toMutableList()
    for(i in mCrewList.indices) {
        if(!checkException(mCrewList[i])) {
            mCrewList.removeAt(i)
        }
    }
}

/**
 * 에외사항을 최종 종합해서 리턴해주는 함수
 */
private fun checkException(crew: List<String>) : Boolean {
    return checkEmailRegex(crew[0]) && checkNameRegex(crew[1])
}

/**
 * 이메일 예외사항 (이메일 형식 -> email.com), 길이 (11자 이상 20자 미만) 인지를 판단 후 T/F값 리턴
 */
private fun checkEmailRegex(email : String) : Boolean {
    return email.contains("email.com") && email.length in 11 until 20
}

/**
 * 닉네임 예외사항 (한글로만 구성되어있는지), 길이 (1자 이상 20자 미만) 인지를 판단 후 T/F값 리턴
 */
private fun checkNameRegex(name : String) : Boolean {
    return Pattern.matches("^[가-힣]*$", name) && name.length in 1 until 20
}


