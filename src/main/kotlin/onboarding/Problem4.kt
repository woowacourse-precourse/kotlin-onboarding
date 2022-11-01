package onboarding

// 기능 목록
// 1. 대문자인지, 소문자인지 혹은 공백인지, 전부 아닌지 구분하는 메소드 구현
// 2. 엄마의 말을 변환 청개구리 말로 변환하는 메소드 구현
// 3. 엄마의 말을 변환하고 StringBuilder로 추합한뒤 형변환을 하고 반환하는 구문 구현

// typeCode
private const val NOT_ALPHABET_SPACE = 0
private const val SPACE = 1
private const val LOWERCASE = 2
private const val UPPERCASE = 3

fun solution4(word: String): String {
    // 기능 목록 3번
    val resultStringBuilder = StringBuilder()

    for (index in word.indices){
        val typeCode = checkChar(word[index])
        val translatedChar = translateFrogLanguage(word[index] , typeCode)

        resultStringBuilder.append(translatedChar)
    }

    return resultStringBuilder.toString()
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
        return 'z' - (targetChar - 'a')
    }

    if (typeCode == UPPERCASE) {
        return 'Z' - (targetChar - 'A')
    }

    return targetChar
}