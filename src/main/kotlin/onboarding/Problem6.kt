package onboarding

// 중복 확인 함수
fun cmparename(a_name: String, b_name: String): Boolean{
    var check: Boolean = false
    for (i in 0..a_name.length - 2) {
        var divide_name: String = a_name.substring(i, i + 2)
        if (b_name.contains(divide_name)) {
            check = true
        }
    }
    return check
}
fun solution6(forms: List<List<String>>): List<String> {
    var answer = mutableListOf<String>()

    for(i in 0..forms.size - 1){
        for(j in 0..forms.size - 1){
            if(i!=j){
                if(cmparename(forms[i][1], forms[j][1])){
                    answer.add(forms[i][0])
                    answer.add(forms[j][0])
                }
            }
        }
    }
    answer.sort()
    var set = answer.toSet()
    var answers = set.toList()
    return answers
}