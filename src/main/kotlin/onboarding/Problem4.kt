package onboarding

fun solution4(word: String): String {
    var resultWord = ""

    for(c in word) {
        resultWord += getConvertedWord(c)
    }

    return resultWord
}

fun getConvertedWord(character: Char): Char {
    return if (character.isUpperCase()) {
        convertUpperCase(character)
    } else {
        convertLowerCase(character)
    }
}

fun convertUpperCase(character: Char): Char {
    val diff = 'Z' - character
    return 'A' + diff
}

fun convertLowerCase(character: Char): Char {
    val diff = 'z' - character
    return 'a' + diff
}