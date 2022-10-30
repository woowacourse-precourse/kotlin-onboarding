package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    if (!validCheck(forms))
        return (listOf("Is not valid"))

    var emails = mutableListOf<String>()
    var crew = 0
    while (crew < forms.size) {
        val nickLen = forms[crew][1].length
        var i = 0
        while (i < nickLen - 1) {
            val overlaps = checkOverlap(crew, i, forms)
            emails.addAll(overlaps)
            i++
        }
        crew++
    }

    // emails 중복제거, 오름차순
    emails = emails.distinct().toMutableList()
    emails.sort()
    return emails
}

fun validCheck(forms: List<List<String>>): Boolean {
    if (forms.size !in 1..10000)
        return false
    else if (!emailCheck(forms))
        return false
    else if (!nickCheck(forms))
        return false
    else
        return true
}

fun nickCheck(forms: List<List<String>>): Boolean {
    for (crew in forms) {
        if (!Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$", crew[1]))
            return false
    }
    return true
}

fun emailCheck(forms: List<List<String>>): Boolean {
    for (crew in forms) {
        if (!Pattern.matches("^[a-zA-Z0-9]{1,9}+@email.com$", crew[0]))
            return false
    }
    return true
}

fun checkOverlap(crew: Int, i: Int, forms: List<List<String>>): List<String> {
    var emails = mutableListOf<String>()
    val word = forms[crew][1].substring(i, i + 2)
    var idx = 0
    while (idx < forms.size) {
        if (idx != crew) {
//			본인이 아닌 경우만 중복체크
            val checkCrew = forms[idx]
            var j = 0
            while (j < checkCrew[1].length - 1) {
                if (forms[idx][1].substring(j, j + 2) == word) {
                    emails.add(checkCrew[0])
                    break
                }
                j++
            }
        }
        idx++
    }
    return emails
}
