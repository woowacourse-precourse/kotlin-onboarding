package onboarding

//기능별 목록
//1.주어진 문자를 리스트로 변환
//2.대문자 일 때 아스키 코드값을 이용한 변경
//3.소문자 일 때 아스키 코드값을 이용한 변경
//4.리스트를 문자로 변환

fun solution4(word: String): String {
    var WordList:MutableList<Char> = word.toMutableList()   //문자를 리스트로 변환

    
    return WordList.joinToString("")    //리스트를 문자로 변환

}
