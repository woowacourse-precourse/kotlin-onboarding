package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    var dup = arrayListOf<String>() /* 비슷한 닉네임을 가진 이메일들을 저장하는 list */
    for(i in 0..forms.size-2){
        for(j in i+1 until forms.size){
            var left = forms[i]
            var right = forms[j]
            if(!isSimilar(left[1], right[1])) continue
            dup.add(left[0])
            dup.add(right[0])
        }
    }
    var result = dup.distinct()
    return result.sorted()
}

/* 두 닉네임 사이에 연속되는 문자 있는지 확인하는 메소드 */
fun isSimilar(str1: String, str2: String) : Boolean{
    for(i in 0..str1.length-2){
        for(j in 0..str2.length-2){
            if(str1[i] != str2[j]) continue
            if(str1[i+1] == str2[j+1]) return true
        }
    }
    return false
}


