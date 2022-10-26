package onboarding

fun solution4(word: String): String {
    var result = ""

    val upperCaseSum = 'A'.code + 'Z'.code
    val lowerCaseSum = 'a'.code + 'z'.code

    word.forEach {
        when (val code = it.code) {
            in 'A'.code..'Z'.code -> {
                result += (upperCaseSum - code).toChar()
            }
            in 'a'.code..'z'.code -> {
                result += (lowerCaseSum - code).toChar()
            }
            else -> {
                result += it
            }
        }
    }

    return result
}
