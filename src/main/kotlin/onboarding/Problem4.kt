package onboarding

fun solution4(word: String): String {
    return buildString {
        for (ch in word) append(ch.greenFrog())
    }
}

/* Returns reverse alphabet */
fun Char.greenFrog(): Char {
    return when{
        isUpperCase() ->  ('Z'.code - (code - 'A'.code)).toChar()
        isLowerCase() ->  ('z'.code - (code - 'a'.code)).toChar()
        else -> this
        }
}
