package onboarding

fun solution4(word: String): String {
    return buildString {
        for (ch in word) append(ch.greenFrog())
    }
}

private fun Char.greenFrog(): Char {
    return if (isUpperCase()) {
        ('Z'.code - (code - 'A'.code)).toChar()
    } else if (isLowerCase()) {
        ('z'.code - (code - 'a'.code)).toChar()
    } else {
        this
    }
}