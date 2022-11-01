package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
}

fun convertAlpha(c: Char): Char{
    if(c in 'A'..'Z'){
        return ('Z' - (c - 'A')).toChar()
    }

    if(c in 'a'..'z'){
        return ('z' - (c - 'a')).toChar()
    }
    return c
}
