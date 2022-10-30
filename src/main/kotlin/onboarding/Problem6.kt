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

        }
    }

}
