package onboarding

/*
기능 목록
- 두 글자 이상 중복되는 문자열 판별
- 중복되는 닉네임이 있는지 판별
*/

fun findDuplicatedSubstring(string1: String, string2: String): Boolean {
    var isCharEqual = false

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

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}
