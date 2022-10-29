package onboarding

fun solution4(word: String): String {
    return word.toCharArray().map {
        when (it) {
            in 'A'..'Z' -> ('A'.code + 'Z'.code- it.code).toChar()
            in 'a'..'z' -> ('a'.code + 'z'.code - it.code).toChar()
            else -> it
        }
    }.joinToString("")
}
