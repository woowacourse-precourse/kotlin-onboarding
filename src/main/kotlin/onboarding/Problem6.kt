package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableListOf<String>()
    val onlyOne = mutableListOf<Pair<Char,Char>>()
    val twoMore = mutableListOf<Pair<Char,Char>>()
    //
    for(i in forms.indices){
        val nickName = forms[i][1]

        val pairs = nickName.zipWithNext()
        for(pair in pairs){
            if(!onlyOne.contains(pair))
                onlyOne.add(pair)
            else if(onlyOne.contains(pair))
                twoMore.add(pair)
        }
    }
    // 중복제거
    twoMore.distinct()
    println(twoMore)


    return result
}
