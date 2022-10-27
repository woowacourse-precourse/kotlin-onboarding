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
    var result = ""

    for (i in 'a'..'z'){
        alphabet.add(i.toString())
    }

    for (s in word){
        var transWord = ""
        var lower = s.lowercase()
        if(s.isLetter()){
            var index = alphabet.indexOf(lower)
            transWord = alphabet[(alphabet.size-1)-index]
            if(s.isUpperCase()){
                transWord = transWord.uppercase()
            }
            result += transWord
        }
        else {
            result += s
        }
    }
    return result
}
