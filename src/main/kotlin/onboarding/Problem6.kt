package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val tokens = MutableList(forms.size){ mutableListOf<String>() }

    for(i in forms.indices){
        val name = forms[i][1]
        for(j in 0..name.length - 2){
            // 한 이름에서 인접한 두 문자씩 추출하여 저장
            val temp = name.substring(j until j+2)
            tokens[i].add(temp)
        }
    }

    val result = mutableSetOf<String>()
    for(i in forms.indices){ // outer loop
        for(j in 0 until tokens[i].size){
            val substr = tokens[i][j]

            for(k in forms.indices){ // inner loop
                if(k == i) continue // 자기 자신은 제외
                for(l in 0 until tokens[k].size){
                    if(substr == tokens[k][l]){
                        // 이메일 저장 (중복 제외 & 자동 정렬)
                        result.add(forms[k][0])
                        result.add(forms[i][0])
                    }
                }
            }
        }
    }

    return result.toList()
}

//fun main(){
//    val forms = listOf(
//        listOf("jm@email.com", "abc"), // 제이엠
//        listOf("jason@email.com", "abd"), // 제이슨
//        listOf("woniee@email.com", "ef"), // 워니
//        listOf("mj@email.com", "cab"), // 엠제이
//        listOf("nowm@email.com", "bac"), // 이제엠
//    )
//    println(solution6(forms))
//}