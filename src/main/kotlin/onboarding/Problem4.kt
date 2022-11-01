package onboarding

const val NUMBER_OF_ALPHABETS = 26
const val LAST_INDEX = 25

fun solution4(word: String): String {
    return translate(word)
}

private fun convert(character: Char): Char {
    // 소문자일 때
    if (character in 'a'..'z') {
        return 'a' + (LAST_INDEX - (character - 'a')) % NUMBER_OF_ALPHABETS
    }
    // 대문자일 때
    else if (character in 'A'..'Z') {
        return 'A' + (LAST_INDEX - (character - 'A')) % NUMBER_OF_ALPHABETS
    } else {
        return character
    }
}

private fun translate(word: String): String {
    return word.map { char -> convert(char) }.joinToString(separator = "")
}
