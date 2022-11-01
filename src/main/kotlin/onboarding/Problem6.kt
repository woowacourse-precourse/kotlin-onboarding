package onboarding

import java.util.Collections
import java.util.stream.Collectors

/* 문제해결 - 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return */
fun solution6(forms: List<List<String>>): List<String> {
    val temp: MutableList<String> = ArrayList()
    for (i in forms.indices) {
        val s = forms[i][1]
        for (j in 0 until s.length - 2) {
            val str = s.substring(j, j + 2)
            for (k in i + 1 until forms.size) {
                if (forms[k][1].contains(str)) {
                    temp.add(forms[i][0])
                    temp.add(forms[k][0])
                }
            }
        }
    }
    val answer = temp.stream().distinct().collect(Collectors.toList())
    Collections.sort(answer)
    return answer
}
