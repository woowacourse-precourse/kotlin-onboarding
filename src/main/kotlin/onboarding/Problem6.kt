package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
    except6(forms)

    val result = mutableSetOf<String>()
    for(i in 0 until forms.size) {
        for(j in i+1 until forms.size ) {
            if(if_intersect(forms[i][1], forms[j][1])) {
                result.add(forms[i][0])
                result.add(forms[j][0])
            }
        }
    }
    return result.toList().sorted()

}

fun except6(forms: List<List<String>>){
    if(forms.size<1||forms.size>10000)
        throw IllegalArgumentException("크루는 1명 이상 10,000명 이하")
}

fun if_subset(nickName: String) : Set<String> {
    val result = mutableSetOf<String>()
    for(i in 0 until nickName.length) {
        for(j in 0 until nickName.length - i) {
            val name = nickName.substring(j, j+i+1)
            if(name.length >= 2) result.add(name)
        }
    }
    return result
}

fun if_intersect(str1: String, str2: String): Boolean {
    val set1 = if_subset(str1)
    val set2 = if_subset(str2)
    for(k in set1) {
        if(set2.contains(k)) return true
    }
    return false
}
