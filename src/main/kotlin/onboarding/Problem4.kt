package onboarding

fun solution4(word: String): String {
    //프로그램 구현

    //예외 사항 1. word가 알파벳 외의 문자인 경우, 변환하지 않고 엄마 말씀 그대로 반환
    if(isAlphabet(word) == false) return word

    return replaceWithDic(word)
}

//예외 사항 1. word가 알파벳 외의 문자인 경우를 확인
fun isAlphabet(word: String): Boolean{
    var trimed = word.filter { !it.isWhitespace() }
    return trimed.all{ it.isLetter() }
}

fun replaceWithDic(word: String): String{
//    val result = ""
    val builder = StringBuilder()

    for(i in word){
        //1. 엄마 말씀 word의 알파벳을 청개구리 사전을 참고해 변환
        if(i.isUpperCase()){ //2. 대문자의 경우 대문자로 변환
            builder.append((155 - i.toInt()).toChar())
        }
        if(i.isLowerCase()){ //2. 소문자의 경우 소문자로 변환
            builder.append((219 - i.toInt()).toChar())
        }
        if(i.isWhitespace()){
            print(i)
            builder.append(" ")
        }
    }
    return builder.toString()
}
