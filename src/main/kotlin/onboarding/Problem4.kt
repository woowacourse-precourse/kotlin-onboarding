package onboarding

fun solution4(word: String): String {
    validateWord(word)

    return word.map { char -> reversedAlphabet(char) }.joinToString("")
}

fun validateWord(word: String) {
    if (word.length !in 1..1000)
        throw IllegalArgumentException("단어의 길이는 1 이상 1000 이하여야 합니다.")
}

fun reversedAlphabet(alphabet: Char): Char {
    return when {
        alphabet.isLowerCase() -> 'z' - (alphabet - 'a')
        alphabet.isUpperCase() -> 'Z' - (alphabet - 'A')
        else -> alphabet
    }
}
