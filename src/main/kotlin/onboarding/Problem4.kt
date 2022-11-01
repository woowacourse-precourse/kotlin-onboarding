package onboarding

fun solution4(word: String): String = word.map { original -> converter(original) }.joinToString("")

fun converter(original: Char): Char {
    val upperCaseSum = 'A'.code + 'Z'.code
    val lowerCaseSum = 'a'.code + 'z'.code

    return when {
        original.isUpperCase() -> (upperCaseSum - original.code).toChar()
        original.isLowerCase() -> (lowerCaseSum - original.code).toChar()
        original.isWhitespace() -> original
        else -> original
    }
}