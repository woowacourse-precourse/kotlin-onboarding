package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val affixes = Array(forms.size){ hashSetOf<String>() }
    val affixesList = findAffixes(forms, affixes)
    val answer = findNickname(forms, affixesList)



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

// 신청받은 닉네임과 중복되는 닉네임을 찾는 기능
fun findNickname(forms: List<List<String>>, affixesList : Array<HashSet<String>>) : MutableList<String>{
    val nicknameList  = mutableListOf<String>()

    for ((i, form) in forms.withIndex()){
        for ( j in affixesList.indices){
            if (i == j) continue
            if (affixesList[i].any{ affixesList[j].contains(it)}){
                println(form)
                nicknameList.add(form[0])
                break
            }
        }
    }
    return nicknameList
}