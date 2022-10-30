package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
}

private fun Char.reverseAlpha(): Char {
    if (!this.isLetter()) return this

    return if (this.isUpperCase()) {
        'Z' - (this - 'A')
    } else {
        'z' - (this - 'a')
    }
}