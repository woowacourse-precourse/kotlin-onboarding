package onboarding

fun solution4(word: String): String {
    return word.map {
        var reverse: Char = it
        if (it in 'a'..'z') {
            reverse = 'a' + ('z' - it)
        } else if (it in 'A'..'Z') {
            reverse = 'A' + ('Z' - it)
        }
        reverse
    }.joinToString("")
}
