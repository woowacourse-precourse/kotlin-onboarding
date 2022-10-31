package onboarding


fun solution4(word: String): String {
    return translate(word)
}

fun convert(character: Char): Char {
    // 소문자일 때
    if (character in 'a'..'z') {
        return 'a' + (25 - (character - 'a')) % 26
    }
    // 대문자일 때
    else if (character in 'A'..'Z') {
        return 'A' + (25 - (character - 'A')) % 26
    } else {
        return character
    }
}

fun translate(word: String): String {
    return word.map { char -> convert(char) }.joinToString(separator = "")
}
