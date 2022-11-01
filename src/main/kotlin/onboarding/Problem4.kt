package onboarding

fun solution4(word: String): String {
    var result = ""

    word.forEach {
        result += translateCharacter(it)
    }

    return result
}

private fun translateCharacter(character: Char): Char {
    val upperCaseSum = 'A'.code + 'Z'.code
    val lowerCaseSum = 'a'.code + 'z'.code

    return when (val code = character.code) {
        in 'A'.code..'Z'.code -> {
            (upperCaseSum - code).toChar()
        }
        in 'a'.code..'z'.code -> {
            (lowerCaseSum - code).toChar()
        }
        else -> {
            character
        }
    }
}
