package onboarding
//두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.
//크루는 1명 이상 10,000명 이하이다.
//이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
//신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
//닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
//result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.
fun solution6(forms: List<List<String>>): List<String> {
    var answer : MutableList<String> = mutableListOf()
    for(i in 0..forms.size-1){
        for(j in i+1..forms.size-1){
            for(k in 0..forms[j][1].length-2){
                if(forms[i][1].contains(forms[j][1].substring(k until k+2))){
                    answer.add(forms[i][0])
                    answer.add(forms[j][0])
                }
            }
        }
    }
    return answer.distinct().sorted()
}