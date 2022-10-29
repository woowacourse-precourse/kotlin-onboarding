package onboarding

fun solution4(word: String): String {
    val lowerCaseIdx = 'a'.code + 'z'.code
    val upperCaseIdx = 'A'.code + 'Z'.code
    var res = ""

    word.forEach {
        res += if (Regex("[a-z]").matches(it.toString())){
            (lowerCaseIdx - it.code).toChar()
        } else if (Regex("[A-Z]").matches(it.toString())){
            (upperCaseIdx - it.code).toChar()
        } else {
            it
        }
    }
    return res
}
