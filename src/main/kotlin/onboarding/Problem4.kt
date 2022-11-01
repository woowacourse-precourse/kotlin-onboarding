package onboarding

fun solution4(word: String): String {

    var result = ""

    for(i in word){
        var ascii = i.toDouble()
        if(65 <= ascii && ascii <= 90){ // 대문자일 경우
            ascii -= 2 * (ascii - 77.5)
        }
        else if(97 <= ascii && ascii <= 122){ // 소문자일 경우
            ascii -= 2 * (ascii - 109.5)
        }
        result += ascii.toChar()
    }

    return result

}