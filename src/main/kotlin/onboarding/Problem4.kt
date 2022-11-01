package onboarding

fun solution4(word: String): String {
    return convertWord(word)
}

// 변환한 문자열을 구하는 함수
fun convertWord(word : String) : String {
    var newWord = ""
    word.forEach {
        newWord += convertChar(it)
    }
    return newWord
}

// 문자를 변환하는 함수
fun convertChar(char: Char) : Char = when(char) {
    in 'A'..'Z' -> ('A'.code + 'Z'.code - char.code).toChar()
    in 'a'..'z' -> ('a'.code + 'z'.code - char.code).toChar()
    else -> char
}

