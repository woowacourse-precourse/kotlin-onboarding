package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    return checkSerialName(forms)
}

fun checkSerialName(forms: List<List<String>>): List<String> { // 리스트 탐색, 이름 2글자 분리 및 대조, 이메일 리스트 저장
    val resultSet = mutableSetOf<String>() // 중복제거 Set

    for (i in forms.indices) {
        // [이메일, 이름]
        val nickName = forms[i][1]
        // [이름, 이름, 이름] 각 인덱스의 이름 저장
        for (j in 0 until nickName.length - 1) {
            val splitName = nickName.substring(j, j + 2)
            // 이름 첫글자부터 +2글자씩 파싱
            for (k in forms.indices) {
                // [이메일, 이름]
                if ((nickName != forms[k][1]) and forms[k][1].contains(splitName)) {
                    // 닉네임!=이름, 파싱된 이름이 포함될 경우
                    resultSet.add(forms[k][0])
                    // 해당 이름의 이메일, 리스트에 저장
                }
            }
        }
    }
    return resultSet.sorted()
    // 오름차순 정렬
}
