package onboarding

/*
 * 기능 요구 사항
 * 1.두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주
 * 2. 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 반환
 * 문제 해결
 * 1. 리스트를 하나씩 보면서 닉네임을 확인한다
 * 2. 확인이 된 닉네임은 반환하도록 리스트에 담아준다
 * 3. 확인이 된 닉네임은 이미 반환해야함으로 체크처리를 해준다
 * 4.
 */
fun solution6(forms: List<List<String>>): List<String> {
    val similarNickNameList = HashSet<String>()
    val email = forms.map { it[0] }
    val name = forms.map { it[1] }
    val duplicateCheck = BooleanArray(forms.size)
    // 같은 글자 연속적으로 포함되는 닉네임 확인
    for (i in 0 until forms.size - 1) {
        if (!duplicateCheck[i]) {
            val nickName = name[i]
            if (1 < nickName.length) {
                // 이름 확인
                for (j in 0 until nickName.length - 1) {
                    val splitNickName = nickName.substring(j, j + 2)
                    // 해당 닉네임이 아닌 다른 forms 에 닉네임들 확인
                    for (k in i + 1 until forms.size) {
                        if (!duplicateCheck[k]) {
                            if (name[k].contains(splitNickName)) {
                                duplicateCheck[k] = true
                                similarNickNameList.add(email[i])
                                similarNickNameList.add(email[k])
                            }
                        }
                    }
                }
            }
        }
    }
    // 오름차순으로 정렬
    return similarNickNameList.sorted()
}
