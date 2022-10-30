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

fun translate(word: String) {

}

fun solution4(word: String): String {
    TODO("프로그램 구현")
}
