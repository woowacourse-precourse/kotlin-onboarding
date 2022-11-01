package onboarding

fun solution4(word: String): String {
    val sb = StringBuilder()
    sb.append(word)

    return sb.map {
        // A-Z -> 65 ~ 90
        // a-z -> 97 ~ 122
        val toAsciiCode = it.toInt()
        if (toAsciiCode in 65..90) {
            return@map (155 - toAsciiCode).toChar()
        }
        if (toAsciiCode in 97..122) {
            return@map (219 - toAsciiCode).toChar()
        }
        if (toAsciiCode == 32) {
            return@map " "
        }

        return@map toAsciiCode
    }.joinToString("")
}
