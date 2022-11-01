package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableListOf<String>()
    for (i in 0..forms.size - 1) {
        for (j in 0..forms[i][1].length - 1) {
            // forms의 인덱스를 초과하지 않기 위해설정
            if (j + 1 > forms[i][1].length - 1) {
                break
            }
        }
    }
    //중복값 제거 후 정렬
    return result.distinct().sorted()
}

