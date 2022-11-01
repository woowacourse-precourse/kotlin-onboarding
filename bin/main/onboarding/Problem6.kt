package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val answer = mutableListOf<String>()
    var word = ""
    for(i in forms.indices){  // 신청자들 목록
        for(j in 0 .. forms[i][1].length-2){    // 단어의 길이
            word = forms[i][1].substring(j,j+2)
            for(k in i+1 until forms.size){     // i번째 다음 닉네임 검사

                if(word in forms[k][1]){
                    if(!answer.contains(forms[i][0]))   // i번째가 answer에 중복되는가
                        answer.add(forms[i][0])     // 중복되지 않으면 추가
                    if(!answer.contains(forms[k][0]))   // k번째가 answer에 중복되는가
                        answer.add(forms[k][0])     // 중복되지 않으면 추가
                }
            }
        }
    }
    return answer.sorted()
}
