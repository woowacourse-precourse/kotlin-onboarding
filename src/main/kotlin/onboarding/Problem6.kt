package onboarding

/*
기능 목록
- 두 글자 이상 중복되는 문자열 판별
- 중복되는 닉네임이 있는지 판별
*/

fun findDuplicatedSubstring(string1: String, string2: String): Boolean {
    var isCharEqual: Boolean

    for (i in string1.indices) {
        var tempIdx = i
        isCharEqual = false
        for (j in string2.indices) {
            if (tempIdx < string1.length && string1[tempIdx] == string2[j]) {
                if (isCharEqual)
                    return true
                isCharEqual = true
                tempIdx++
            } else {
                isCharEqual = false
            }
        }
    }
    return false
}

fun findDuplicatedNickname(forms: List<List<String>>): List<String> {
    val r = mutableListOf<String>()
    for (i in forms.indices) {
        var isDuplicated = false
        for (j in 0 until forms.size - 1) {
            if (i != j && findDuplicatedSubstring(forms[i][1], forms[j][1])) {
                if (!r.contains(forms[j][0]))
                    r.add(forms[j][0])
                isDuplicated = true
            }
        }
        if (isDuplicated && !r.contains(forms[i][0]))
            r.add(forms[i][0])
    }
    r.sort()
    return r
}

fun solution6(forms: List<List<String>>): List<String> {
    return findDuplicatedNickname(forms)
}
