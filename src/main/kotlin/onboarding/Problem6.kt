package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    /*
    [기능 목록]
    1. forms에서 중복을 구할 기준이 되는 인덱스를 지운 리스트 생성
    2. 기준 닉네임을 한 문자씩 읽기
    2. 비교할 닉네임 안에 기준 닉네임과 같은 문자가 있다면, 비교할 닉네임에서의 해당 문자의 인덱스 구하기
    3. 비교할 닉네임과 기준 닉네임 각각, 같은 문자의 다음 문자가 같다면 중복
     */

    var result = mutableListOf<String>()

    for (i in forms.indices){
        var nickName = forms[i][1]
        var newForms = forms.toMutableList()
        newForms.removeAt(i)
        println(newForms)
    }
    return listOf("Hello World")
}
