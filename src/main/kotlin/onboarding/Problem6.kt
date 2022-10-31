package onboarding

// 기능 목록
// 1. 사용할 HashSet과 MutableMap 선언
// 2. 닉네임을 하나 받아 2글자씩 순회하면서 해시맵에 저장하는 메소드 구현
// 3. 중복된 닉네임을 가진 이메일들을 추합하여 정렬하여 리턴

// 기능 목록 1번
private val resultEmails = HashSet<String?>()
private val duplicationCheckMap: MutableMap<String, String> = HashMap()

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

// 기능 목록 2번
fun addMapItem(forms: List<List<String>>, nickname: String) {
    for (index in 0 until nickname.length - 1) {
        val key = nickname.substring(index, index + 2)

        if (duplicationCheckMap.containsKey(key)) {
            val email = duplicationCheckMap[key]

            if (email != forms[index][0]) {
                resultEmails.add(email)
                resultEmails.add(forms[index][0])
            }
        }

        duplicationCheckMap[key] = forms[index][0]
    }
}