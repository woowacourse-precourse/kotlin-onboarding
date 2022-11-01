package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableListOf<String>()

    // 자기와 한 번이라도 중복되는 것이 있으면 result에 추가하고 넘어간다.
    for (form in forms) {
        val nickname = form[1]

        for (targetForm in forms) {
            // 자기 자신하고는 비교 x
            if (form == targetForm)
                continue
            val targetNickname = targetForm[1]
            if (nicknameContains(nickname, targetNickname)) {
                result.add(form[0])
                break
            }
        }
    }

    // 정렬
    result.sort()
    return result
}

// 닉네임에 중복되는 것이 있으면 true를 리턴하는 함수
private fun nicknameContains(nickname: String, targetNickname: String): Boolean {
    // nickname의 2글자씩 묶어서 targetNickname과 비교한다.(contains 메서드 사용)
    for (i in 0 until nickname.length - 1) {
        val twoWord = nickname.substring(i, i + 2)
        if (targetNickname.contains(twoWord))
            return true
    }

    return false
}