package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val tokens = MutableList(forms.size){ mutableListOf<String>() }

    for(i in forms.indices){ // 1만 이하
        val name = forms[i][1]
        for(j in 0..name.length - 2){ // 20자 미만
            // 한 이름에서 인접한 두 문자씩 추출하여 저장
            val temp = name.substring(j until j+2)
            tokens[i].add(temp)
        }
    }

    val result = mutableSetOf<String>() // 중복 제외, 자동 정렬을 위해 Set 사용
    for(i in forms.indices){ // outer loop (1만)
        for(j in 0 until tokens[i].size){ // 20개 미만
            val substr = tokens[i][j]

            for(k in forms.indices){ // inner loop (1만)
                if(k == i) continue // 자기 자신은 제외
                for(l in 0 until tokens[k].size){ // 20개 미만
                    // 연속으로 중복된 문자가 발견되면
                    if(substr == tokens[k][l]){
                        // 해당 이메일 저장
                        result.add(forms[k][0])
                        result.add(forms[i][0])
                    }
                }
            }
        }
    }

    return result.toList()
}