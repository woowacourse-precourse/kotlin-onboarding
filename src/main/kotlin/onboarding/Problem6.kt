package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

/* 두 문자열 사이에 연속되는 문자 있는지 확인하는 메소드 */
fun isSimilar(str1: String, str2: String) : Boolean{
    for(i in 0..str1.length-2){
        for(j in 0..str2.length-2){
            if(str1[i] != str2[j]) continue
            if(str1[i+1] == str2[j+1]) return true
        }
    }
    return false
}


