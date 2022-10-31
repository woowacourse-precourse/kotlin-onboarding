package onboarding

fun solution4(word: String): String {

    var alphabet = listOf<Char>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'N', 'M', 'O', 'P'
        ,'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    alphabet.reversed()

    var result = ""
    for (i in word.indices) {
        result += if (word[i].isUpperCase()) {
            ('A' + ('Z' - word[i]))
        } else if (word[i].isLowerCase()) {
            ('a' + ('z' - word[i]))
        } else {
            (word[i])
        }
    }

    return result
}
