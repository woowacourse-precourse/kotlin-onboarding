package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val maillist = mutableListOf<String>() // list말고 set으로 설정하면 중복제거 가능할수도

    for (i in forms.indices){ // indices 유효한 범위 자동할당

        for (j in i+1 until forms.size){ // 다음메일 탐색

            for (k in 0 until forms[i][1].length-1){
                val check = forms[i][1][k]+forms[i][1][k+1].toString() // 단어조합

                if (check in forms[j][1]){ // 조합된 단어가 포함된다면
                    maillist.add(forms[j][0]) // 중복메일 추가
                    maillist.add(forms[i][0]) // 중복메일 추가
                    break
                }
            }
        }
    }
    return maillist.toList().sorted().distinct() //  정렬, 중복제거
}