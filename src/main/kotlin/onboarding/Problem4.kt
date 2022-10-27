package onboarding

fun solution4(word: String): String {
    exception4(word)
    return changeWord(word)
}

fun exception4(word : String) {
    if(word.length < 1 || word.length > 1000) {
        throw IllegalArgumentException("word의 길이는 1이상 1000이하여야 합니다.")
    }
}

fun changeChar(char: Char) : Char = when(char) {
    in 'A'..'Z' -> ('A'.toInt() + 'Z'.toInt() - char.toInt()).toChar()
    in 'a'..'z' -> ('a'.toInt() + 'z'.toInt() - char.toInt()).toChar()
    else -> char
}

fun changeWord(word : String) : String {
    var result = ""

    result += word.map {
        changeChar(it)
    }

    return result
}
