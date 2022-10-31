package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val tokensTemp = mutableListOf<String>() // 처음 나온 토큰 모음
    val tokens = mutableListOf<String>() // 두번 이상 나온 토큰 모음 (중복인 토큰들)
    val result = mutableListOf<String>()
    // 토큰 구하기
    for(idx: Int in forms.indices) {
        val name = forms[idx][1]

        for(start:Int in 0 until name.length-1) {
            var subs = name.substring(start, start+2)
            if (tokensTemp.contains(subs) && !tokens.contains(subs)) {
                tokens.add(subs)
            } else {
                tokensTemp.add(subs)
            }
        }
    }
    // 중복 구하기
    for(idx: Int in forms.indices) {
        val name = forms[idx][1]

        for(idx2: Int in tokens.indices) {
            if(name.contains(tokens[idx2])) {
                result.add(forms[idx][0])
                break
            }
        }
    }

    result.distinct() // 중복 제거
    return result.sorted()
}
