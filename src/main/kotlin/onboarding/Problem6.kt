package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val affixes = Array(forms.size){ hashSetOf<String>() }
    val affixesList = findAffixes(forms, affixes)
    
    return listOf()
}


// 신청받은 닉네임 중 중복이 가능한 모든 접사를 찾는 기능
fun findAffixes(forms: List<List<String>>, affixes : Array<HashSet<String>>) : Array<HashSet<String>>{
    for ((idx, form) in forms.withIndex()){
        for (i in 0 until form[1].lastIndex){
            for (j in i+1 .. form[1].lastIndex)
                affixes[idx].add(form[1].slice(i..j))
        }
    }

    return affixes

}
