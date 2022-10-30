package onboarding

//기능별 목록
//1. 닉네임 추출
//2. 닉네임 중복될 수 있는 단어 추출
//3. 중복되는 단어 추출
//4. 단어가 포함되어 있는 사용자 이메일 추출

fun solution6(forms: List<List<String>>): List<String> {
    val nicknamelist = onlynickname(forms)  //닉네임 추출

    return nicknamelist
}

//닉네임 추출 함수
fun onlynickname(forms: List<List<String>>): List<String>{
    val nicknamelist:MutableList<String> = mutableListOf()
    for(i:Int in forms.indices){
        nicknamelist.add(forms[i][1])
    }
    println(nicknamelist)
    return nicknamelist
}

