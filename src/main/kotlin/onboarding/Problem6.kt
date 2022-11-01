package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableListOf<String>()
    for (i in 0..forms.size - 1) {
        for (j in 0..forms[i][1].length - 1) {
            // forms의 인덱스를 초과하지 않기 위해설정
            if (j + 1 > forms[i][1].length - 1) {
                break
            } else {
                // 연속되는 2개의 문자
                val overlapFirstString = forms[i][1][j]
                val overlapSecondString = forms[i][1][j + 1]
                for (k in i + 1..forms.size - 1) {
                    //연속되는 2개의 문자를 포함하고 있는 boolean 값이 트루면 가지면 결과값의 추가 k=index+1의 다음 인덱스
                    if (forms[k][1].contains(overlapFirstString + overlapSecondString.toString()) == true) {
                        //일단 중복되는 형태의 이메일 모두 저장
                        result.add(forms[i][0])
                        result.add(forms[k][0])
                    }
                }
            }
        }
    }
    //중복값 제거 후 정렬
    return result.distinct().sorted()
}

