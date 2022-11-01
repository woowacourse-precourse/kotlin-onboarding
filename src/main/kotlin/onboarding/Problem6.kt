package onboarding

/*
    두 글자 이상의 문자가 연속적으로 순서에 맞추어
    포함되어 있는 경우 중복으로 간주한다.
 */
fun <T> convertToSet(list: List<T>): Set<T> {
    return HashSet(list)
}

fun solution6(forms: List<List<String>>): List<String> {
    val ans = mutableListOf<String>()

    // 크루의 인원수만큼 반복
    for (i in 0..forms.size-1){
        val nicknameChar = forms[i][1].chunked(1)

        for (j in 0 .. nicknameChar.size-2){
            for (k in i+1..forms.size-1){
                val nicknameCharCompare = forms[k][1].chunked(1)

                for (n in 0..nicknameCharCompare.size-2){
                    // 글자 하나가 같다면
                    if ( nicknameChar[j] == nicknameCharCompare[n] ){
                        // 다음 글자를 비교

                        if (nicknameChar[j+1] == nicknameCharCompare[n+1]){
                            // 해당 닉네임을 넣는다
                            ans.add(forms[i][0])
                            ans.add(forms[k][0])
                        }
                    }
                }
            }
        }
    }

    val set: Set<String> = convertToSet(ans)
    val email_answer: List<String> = set.toList().sorted()
    return email_answer
}
