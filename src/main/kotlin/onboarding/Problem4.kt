package onboarding

fun convert(character: Char): Char {
    // 소문자일 때
    if ('a' <= character && character <= 'z') {
        return 'a' + (25 - (character - 'a')) % 26
    }
    // 대문자일 때
    else if ('A' <= character && character <= 'Z'){
        return 'A' + (25 - (character - 'A')) % 26
    } else {
        return character
    }
}

fun translate(word: String): String {
    return word.map { char -> convert(char) }.joinToString(separator = "")
}

fun solution4(word: String): String {
    return translate(word)
}
