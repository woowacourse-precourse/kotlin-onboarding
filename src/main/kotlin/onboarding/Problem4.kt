package onboarding

fun solution4(word: String): String {
    return convertWord(word)
}

fun convertWord(word : String) : String {
    var newWord = ""
    word.forEach {
        newWord += convertChar(it)
    }
    return newWord
}

fun convertChar(char: Char) : Char = when(char) {
    in 'A'..'Z' -> ('A'.code + 'Z'.code - char.code).toChar()
    in 'a'..'z' -> ('a'.code + 'z'.code - char.code).toChar()
    else -> char
}

