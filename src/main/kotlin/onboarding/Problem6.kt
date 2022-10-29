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
private fun checkException(crew: List<String>) : Boolean {
    return checkEmailRegex(crew[0])
}

private fun checkEmailRegex(email : String) : Boolean {
    return email.contains("email.com") && email.length in 11 until 20
}

