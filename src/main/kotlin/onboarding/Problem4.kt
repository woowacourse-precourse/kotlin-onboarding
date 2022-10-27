package onboarding

fun solution4(word: String): String {
    /*
    [기능 목록]
    1.문자를 변환하여 문자열에 추가하기
        a) 알파벳 여부 확인
        b) 대소문자 판별
        c) 문자 변환
     */
    val alphabet = mutableListOf<String>()
    var result: String = ""

    for (i in 'a'..'z'){
        alphabet.add(i.toString())
    }

    for (s in word){
        if(s.isLetter()){
            println("${s}는 알파벳")
        }
        else {
            println("알파벳이 아님")
        }
    }
    return "Hello World"
}
