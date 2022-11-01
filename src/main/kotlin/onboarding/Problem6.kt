package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableListOf<String>()
    val pairData = mutableMapOf<Pair<Char,Char>,Int>()

    // 1번.  전체 nickName돌면서 각 pair가 몇번 나오는지 확인 ( 한 nickName에서 나오는 중복 제거 필요)
    for(form in forms){
        val nickName = form[1]
        val pairs = nickName.zipWithNext()
        val noDuplicatePairs = pairs.toSet()
        for(pair in noDuplicatePairs){
            if (!pairData.containsKey(pair))
                pairData[pair]=0
            pairData[pair] = pairData[pair]!! + 1
        }
    }

    // 2번 count가 2번 이상인 pair가 있는 닉네임들의 email 추출 수정 필요
    for(i in forms.indices){
        val email = forms[i][0]
        val nickName = forms[i][1]
        val pairs = nickName.zipWithNext()
        for (pair in pairs){
            if(pairData.containsKey(pair) && pairData[pair]!!>1){
                result.add(email)
                break
            }
        }
    }
    result = result.distinct() as MutableList<String>
    return result.sorted()
}
