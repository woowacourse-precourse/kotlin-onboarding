package onboarding

fun solution4(word: String): String {
    //TODO("프로그램 구현")
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