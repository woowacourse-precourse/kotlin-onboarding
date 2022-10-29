package onboarding

// 기능 목록
// 1. 대문자인지, 소문자인지 혹은 공백인지, 전부 아닌지 구분하는 메소드 구현
// 2. 엄마의 말을 변환 청개구리 말로 변환하는 메소드 구현
// 3. 엄마의 말을 본격적으로 변환하는 구문 구현

const val NOT_ALPHABET_SPACE = 0
const val SPACE = 1
const val LOWERCASE = 2
const val UPPERCASE = 3

fun solution4(word: String): String {
    TODO("프로그램 구현")
}

// 기능 목록 1번
fun checkChar(target: Char): Int {
    if (target == ' ') {
        return SPACE
    }

    if (target in 'a'..'z') {
        return LOWERCASE
    }

    if (target in 'A'..'Z') {
        return UPPERCASE
    }

    return NOT_ALPHABET_SPACE
}

// 기능 목록 2번
fun translateFrogLanguage(targetChar: Char, typeCode: Int): Char {
    if (typeCode == SPACE) {
        return ' '
    }

    if (typeCode == LOWERCASE) {
        return targetChar + 25 - (targetChar - 'a')
    }

    if (typeCode == UPPERCASE) {
        return targetChar + 25 - (targetChar - 'A')
    }

    return targetChar
}