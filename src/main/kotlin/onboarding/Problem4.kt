package onboarding

fun treeFrog(c : Char): Char{

    //알파벳 숫서 반대로
    //대문자는 대문자로, 소문자는 소문자로로
    if(c.code in(65 .. 90)){
        return (155 - c.code).toChar()
    }else if(c.code in (97 .. 122) ){
        return (219 - c.code).toChar()
    }else{
        return c
    }
}

fun solution4(word: String): String {
    return word.map{treeFrog(it)}.joinToString("")
}
