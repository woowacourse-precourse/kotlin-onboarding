package onboarding

fun solution4(word: String): String {
    var result:String = ""
    for(c in word){
        result += convertAlpha(c)
    }
    return result
}

/* 변환된 알파벳을 출력하는 convertAlpha 메소드 구현 */
fun convertAlpha(c: Char): Char{
    if(c in 'A'..'Z'){
        return ('Z' - (c - 'A')).toChar()
    }

    if(c in 'a'..'z'){
        return ('z' - (c - 'a')).toChar()
    }
    return c
}
