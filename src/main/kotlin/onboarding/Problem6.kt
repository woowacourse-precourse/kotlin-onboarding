package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableListOf<String>()
    val onlyOne = mutableListOf<Pair<Char,Char>>()
    var twoMore = mutableListOf<Pair<Char,Char>>()
    // 1번. 각 닉네임 두 글자씩 pair로 나누고, 조건에 따라 처음 나온 pair, 두 번 이상 나온 pair로 두 개의 리스트에 나눠서 넣기
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
    twoMore= twoMore.distinct() as MutableList<Pair<Char, Char>>

    // 2번. 각 닉네임에서 두번 이상 나온 pair를 가지고 있는 list에 있는 pair가 있는 경우 result에 이메일 넣는 기능
    for(i in forms.indices){
        val email = forms[i][0]
        val nickName = forms[i][1]
        val pairs = nickName.zipWithNext()
        for (pair in pairs){
            if(twoMore.contains(pair)){
                result.add(email)
                break
            }
        }
    }
    result = result.distinct() as MutableList<String>
    return result.sorted()
}
