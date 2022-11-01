package onboarding

//두글자 연속 같은 닉네임 -> 이메일 목록 리턴
// 1 <= n <= 10,000
// 이메일 도메인 :email.com -> 정규식 :
// 닉넴 한글, 1~19 -> 정규식

fun solution6(forms: List<List<String>>): List<String> {
    //겹치는 닉넴
    var name_list = mutableListOf<String>()
    //반환 리스트
    var email_list = mutableListOf<String>()


    for(i in 0 until forms.size){
        for(j in 1 until forms[i][1].length){
            //두글자씩 추출
            val jm = forms[i][1].substring(j .. j+1)
            print(jm)
        }


    }


    return email_list
}
