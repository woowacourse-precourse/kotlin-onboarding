package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val list = forms
    var email_list = mutableListOf<String>()
    for(i : Int in 0..list.size-1){
        for(j: Int in 0.. list[i][1].length-2){
            var check = list[i][1].slice(j..j+1)// 최소 2글자 중복이므로 2글자 슬라이스
            for (k: Int in i+1..list.size-1){
                if(check in list[k][1]){ // 일치하는 글자가 있을경우 email_list에 추가
                    email_list.add(list[i][0])
                    email_list.add(list[k][0])
                }
            }
        }
    }
    return email_list.distinct().sorted()
}
