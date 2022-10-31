package onboarding
fun solution4(word: String): String {
    var convertedWord = ""

    val lowerCaseRange = 'a'.code + 'z'.code
    val upperCaseRange = 'A'.code + 'Z'.code

    word.forEach {
        convertedWord += when(it) {
            in 'a' .. 'z' -> (lowerCaseRange - it.code).toChar()
            in 'A' .. 'Z' -> (upperCaseRange - it.code).toChar()
            else -> it
        }
    }

    return convertedWord
}

