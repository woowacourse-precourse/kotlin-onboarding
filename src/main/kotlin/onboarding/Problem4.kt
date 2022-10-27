package onboarding
/*
기능항목 정리
1. 소문자, 대문자, 그리고 공백을 구분하는 기능
2. 알파벳을 규칙대로 치환하는 기능
 */
fun solution4(word: String): String {
    return word.map {
        when(it){
            in 'a'..'z'-> 'a'+('z'-it)//소문자인 경우
            in 'A'..'Z'-> 'A'+('Z'-it)//대문자인 경우
            else -> it//공백인경우
        }
    }.joinToString("")
}

