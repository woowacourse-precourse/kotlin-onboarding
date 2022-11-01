package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    //이메일 중복 기록 방지를 위한 mutableSet 선언
    var emailSet = mutableSetOf<String>()

    //비교 기준 닉네임
    for (i in (0..forms.size-1)){
        var wordList = forms[i][1].split("").toMutableList()
        wordList.removeAt(wordList.size-1)
        wordList.removeAt(0)

        //비교 대상 닉네임
        for (j in (0..forms.size-1)){
            //동일 회원은 서로 비교 안함
            if (i == j){
                continue
            }
            //두 글자씩 잘라서 비교
            for (k in (0..wordList.size-2)){
                var word = wordList[k] + wordList[k+1]

                //포함되면 email 리스트에 추가
                if (forms[j][1].contains(word)){
                    emailSet.add(forms[j][0])
                    emailSet.add(forms[i][0])
                }
            }
        }
    }

    //email 리스트 정렬
    var emailList = emailSet.toMutableList()
    emailList.sort()

    return emailList
}
