package onboarding

//기능 목록
/*
    1. 각 크루들의 닉네임이 서로 연속적으로 포함되는 닉네임을 갖고 있는지 확인
    2. 1. 에서 연속적으로 포함되는 닉네임이 있다면, 해당 닉네임의 email을 리스트에 따로 저장
    3. email 리스트를 오름차순으로 정렬하고 중복 제거 후 return
 */
//예외 사항
/*
    1. 닉네임이 한글이 아닐 경우 예외 처리
    2. email의 도메인이 email.com이 아닐 경우 예외 처리
    3. email이 이메일 형식에 부합하지 않을 경우 예외 처리
 */


fun solution6(forms: List<List<String>>): List<String> {
    //프로그램 구현

    //3. email 리스트를 중복 제거
    var result = duplicateNameList(forms).toSet().toList()
    //3. email 리스트 오름차순으로 정렬
    result = result.sortedBy { it }
    //3. return
    return result
}

//1. 각 크루들의 닉네임이 서로 연속적으로 포함되는 닉네임을 갖고 있는지 확인
fun duplicateNameList(forms: List<List<String>>): List<String> {
    var duplicateEmail = mutableListOf<String>()
    var temp = mutableMapOf<String, String>()

    for(i in forms.indices){
        val email = forms[i][0]
        val nickname = forms[i][1]

        for(j in 0 until nickname.length - 1){
            val sub = nickname.substring(j, j+1)
            if(temp.containsKey(sub)){ //2. 1. 에서 연속적으로 포함되는 닉네임이 있다면, 해당 닉네임의 email을 리스트에 따로 저장
                val key = temp[sub]
                if(key != email)
                    duplicateEmail.add(key.toString())
                duplicateEmail.add(email)
            }
            else{
                temp[sub] = email
            }
        }
    }
    return duplicateEmail
}