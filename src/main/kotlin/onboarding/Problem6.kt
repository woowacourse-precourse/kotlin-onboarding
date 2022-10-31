package onboarding

import kotlin.math.max

fun solution6(forms: List<List<String>>): List<String> {
    var result = mutableListOf<String>()
    var flag = false
    forms.forEachIndexed { index1, list1 ->
        forms.forEachIndexed { index2, list2 ->
            if (index1 != index2){
                val lcs = LCSubstring(list1[1], list2[1]) // length of longest common substring
                if (lcs > 1) flag = true // if the nickname overlapped
            }
        }
        if (flag) result.add(list1[0]) // add wrong nickname's email
        flag = false // reset flag
    }
    return result.distinct().sorted() // remove repeat and sortedByAscending
}

// find longest commong substring
fun LCSubstring(str1: String, str2: String): Int{
    var cnt = 0
    for (i in 0 until (str1.length)){
        for (j in 0 until (str2.length)){
            var k = 0
            while ((i+k) < str1.length && (j+k) < str2.length
                && str1[i+k] == str2[j+k])
                k += 1
            cnt = max(cnt, k)
        }
    }
    return cnt
}