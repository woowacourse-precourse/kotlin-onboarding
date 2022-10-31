package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val answer = mutableSetOf<String>()
    val check = BooleanArray(forms.size+1)
    // 같은 글자가 연속적으로 포함될 경우
    for (i in forms.indices){
        // 현재 글자의 다음 글자부터 탐색
        for (j in i+1 until forms.size){
            // answer 들어 있는 않은 닉네임만 탐색
            if (!check[j]){
                // 현재 글자를 두글자씩 조합하여 포함되는지 탐색
                for (k in 0 until forms[i][1].length-1){
                    val twoWord = forms[i][1][k]+forms[i][1][k+1].toString()
                    // 현재 탐색 중인 forms에 towWord가 포함된다면 answer에 넣음
                    if (twoWord in forms[j][1]){
                        check[j] = true
                        answer.add(forms[j][0])
                        answer.add(forms[i][0])
                        break
                    }
                }
            }
        }
    }
    return answer.toList().sorted()
}
