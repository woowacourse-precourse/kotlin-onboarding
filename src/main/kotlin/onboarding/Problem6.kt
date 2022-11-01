package onboarding

/**
기능 목록
- 닉네임이 두 글자 이상 중복되는지 확인
- 중복되는 경우 Set에 넣기
- 오름차순 정렬
- checkNickName: 닉네임이 두 글자 이상 중복되는 것이 있으면 true 반환
 */

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()

    for (indexList in forms.indices) {
        val email = forms[indexList][0]
        if (checkNickName(indexList, forms)) result.add(email)
    }
    return result.toList().sorted()
}

private fun checkNickName(indexList: Int, forms: List<List<String>>): Boolean {
    val name = forms[indexList][1]
    for (nameIndex in 0 until name.length - 1) {
        val twoLetters = name.substring(nameIndex, nameIndex + 2)
        for (index in forms.indices) {
            if (forms[index][1].contains(twoLetters) && indexList != index) {
                return true
            }
        }
    }
    return false
}