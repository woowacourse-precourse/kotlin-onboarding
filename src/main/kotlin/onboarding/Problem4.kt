package onboarding

fun solution4(word: String): String {

    return changeString(word)
}
fun changeChar(char: Char) : Char = when(char) {
    in 'A'..'Z' -> ('A'.code + 'Z'.code - char.code).toChar()
    in 'a'..'z' -> ('a'.code + 'z'.code - char.code).toChar()
    else -> char
}

fun changeString(str : String) : String {
    var word = ""
    str.forEach {
        word += changeChar(it)
    }
    return word
}
