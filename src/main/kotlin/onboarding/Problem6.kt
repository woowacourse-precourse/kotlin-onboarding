package onboarding

/*
기능항목 정리
1. 같은글자가 연속적으로 포함되는 닉네임 찾기 기능
2. 중복되지 않게 이메일을 결과에 넣기 기능
3. 이메일 기준으로 오름차순으로 정렬하기 기능
 */
fun solution6(forms: List<List<String>>): List<String> {

    val substringEmailMap = mutableMapOf<String, String>()
    val emailSet = mutableSetOf<String>()

    forms.forEach { form ->
        val email = form[0]
        val nickName = form[1]
        for (k in 0..nickName.length - 2) {
            val key = nickName.substring(k, k + 2)
            if (substringEmailMap.containsKey(key)) {
                if (substringEmailMap[key] != email) {
                    substringEmailMap[key]?.let { value ->
                        emailSet.add(value)
                    }
                    emailSet.add(email)
                }
            }
            substringEmailMap[key] = email
        }
    }
    return emailSet.sorted().toList()
}

