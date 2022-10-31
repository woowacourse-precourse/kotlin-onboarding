package onboarding

fun solution4(word: String): String {
    val sb = StringBuilder()
    word.map { letter ->
        with(letter) {
            if (isUpperCase()) {
                sb.append(('A' + ('Z' - letter)))
            } else if (isLowerCase()) {
                sb.append(('a' + ('z' - letter)))
            } else {
                sb.append(letter)
            }
        }
    }
    return sb.toString()
}
