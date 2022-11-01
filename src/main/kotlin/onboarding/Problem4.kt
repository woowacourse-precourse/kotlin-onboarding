package onboarding

//기능 목록
/*
    1. 엄마 말씀 word의 알파벳을 청개구리 사전을 참고해 변환
    2. 알파벳 대문자의 경우 대문자로, 소문자의 경우 소문자로 변환
 */
//예외 사항
/*
    1. word가 알파벳 외의 문자인 경우
 */
fun solution4(word: String): String {
    //프로그램 구현
    return replaceWithDic(word)
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
