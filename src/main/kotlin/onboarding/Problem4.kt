package onboarding

fun changeUpperCase(alphabet: Char): Char =
    ('Z'.code - alphabet.code + 'A'.code).toChar()


fun changeLowerCase(alphabet: Char): Char =
    ('z'.code - alphabet.code + 'a'.code).toChar()


fun changeCharacter(character: Char): Char = when (character) {
    in 'A'..'Z' -> changeUpperCase(character)
    in 'a'..'z' -> changeLowerCase(character)
    else -> character
}

fun solution4(word: String): String {
    var res = ""
    for (c in word) {
        res += changeCharacter(c)
    }
    return res
}
