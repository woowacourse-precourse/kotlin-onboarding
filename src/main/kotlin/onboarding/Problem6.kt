package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    /*
    1. 모든 닉네임을 두글자씩 잘라서 allKeywordSet에 넣는다
    2. 이때 allKeywordSet에 중복된 글자가 있으면 duplicatekeywordSet에 중복 글자를 넣고 중복이 발생한 이메일을 duplicateEmailSet에 넣는다.
    3. 최초로 키워드를 등록한 이메일은 dubplicateEmailSet에 들어가지 않았으므로, 반복문을 통해 duplicatekeywordSet에 있는 단어를 비교하여 duplicateEmailSet을 완성한다.
    4. 문자를 오름차순으로 정렬 후 리턴한다
     */
    var nick:String=""
    var str:String="" //두글자씩 조갤 데이터
    val allKeywordSet =mutableSetOf<String>() //모든 두글자들의 집합
    val duplicateEmailSet =mutableSetOf<String>() //중복이 발생한 이메일 리스트
    val duplicateKeywordSet= mutableSetOf<String>() //중복 키워드 집합
    val formsSet= mutableSetOf<String>() //입력받은 forms의 이메일을 Set에 저장

    if(forms.size<1){
        return formsSet.toList()  //사이즈가 1보다 작다면 빈리스트 반환
    }

    //먼저 닉네임을 두글자씩 쪼개어 allSet 집합에 담는다
    //이과정에서 중복이 발생한 이메일과 중복 문자열은 각각 duplicateEmialSet,dubplicateKeywordSet 집합에 담는다
    for(i in 0 until forms.size){
        formsSet.add(forms[i][0])  //모든 이메일을 formsSet에 담는다.
        nick=forms[i][1]
        for(j in 0 until nick.length-1){
            if(nick.length>1){ //닉네임이 한글자라면 무시
                str=nick.substring(j until j+2)
            }
            else{
                break
            }

            if(allKeywordSet.contains(str)){
                duplicateEmailSet.add(forms[i][0])
                duplicateKeywordSet.add(str)
            }
            else{
                allKeywordSet.add(str)
            }
        }
    }
    val substractSet=formsSet.subtract(duplicateEmailSet)  //전체 이메일집합과 중복된 이메일집합의 차집합
    for(i in 0 until substractSet.size){
        nick=forms[i][1]
        for(j in 0 until nick.length-1){
            str=nick.substring(j until j+2)
            if(duplicateKeywordSet.contains(str)){
                duplicateEmailSet.add(forms[i][0])
            }
        }
    }

    return duplicateEmailSet.sorted().toMutableList() //정렬된 리스트 반환
    
}
