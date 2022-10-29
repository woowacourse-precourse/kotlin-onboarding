package onboarding

fun solution4(word: String): String {
    return word.toCharArray().map {

        val capitalLetterReturn = ('A'.code + 'Z'.code- it.code).toChar()
        val smallLetterReturn = ('a'.code + 'z'.code - it.code).toChar()

        when (it) {
            in 'A'..'Z' -> capitalLetterReturn
            in 'a'..'z' -> smallLetterReturn
            else -> it
        }
    }.joinToString("")
}
