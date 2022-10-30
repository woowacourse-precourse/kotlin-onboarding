package onboarding

fun solution4(word: String): String {
    val upperACode = 65
    val upperZCode = 90
    val lowerACode = 97
    val lowerZCode = 122

    return word.map {
        val c = when (val code = it.code) {
            in 65..90 -> upperACode + upperZCode - code
            in 97..122 -> lowerACode + lowerZCode - code
            else -> code
        }
        c.toChar()
    }.joinToString("")
}