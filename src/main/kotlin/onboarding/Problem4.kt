package onboarding

fun solution4(word: String): String {
    val sb = StringBuilder()
    word.forEach { sb.append(it.reverseAlpha()) }
    return sb.toString()
}

private fun Char.reverseAlpha(): Char {
    if (!this.isLetter()) return this

    return if (this.isUpperCase()) {
        'Z' - (this - 'A')
    } else {
        'z' - (this - 'a')
    }
}