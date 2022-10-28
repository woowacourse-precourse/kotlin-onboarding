package onboarding

fun solution4(word: String): String {

    word.forEach {
        changeChar(it)
    }
    return ""
}
fun changeChar(char: Char) : Char = when(char) {
    in 'A'..'Z' -> ('A'.code + 'Z'.code - char.code).toChar()
    in 'a'..'z' -> ('a'.code + 'z'.code - char.code).toChar()
    else -> char
}

