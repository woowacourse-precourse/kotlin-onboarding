package onboarding

fun solution4(word: String): String {

    var alphabet = listOf<Char>('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'N', 'M', 'O', 'P'
        ,'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    alphabet = alphabet.reversed()

    val s = "I love you"
    var ans = ""
    for (i in s.indices) {
        if (s[i].isUpperCase()) {
            ans += ('A' + ('Z' - s[i]))
        } else if (s[i].isLowerCase()) {
            ans += ('a' + ('z' - s[i]))
        } else if (s[i] == ' ') {
            ans += (' ')
        } else {
            ans += (s[i])
        }
    }

    return ans
}
