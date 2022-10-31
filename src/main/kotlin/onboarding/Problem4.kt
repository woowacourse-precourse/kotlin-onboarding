package onboarding

import java.lang.StringBuilder

/*
기능 목록
- 문자 변환
    - 각 문자에 대해 알파벳상 반대로 변환
- 문자열 변환
    - 문자열 순회하며 문자 변환 적용
*/

fun conversionChar(char: Char): Char {
    return if (char.isUpperCase()) {
        (90 + 65 - char.code).toChar()
    } else {
        (122 + 97 - char.code).toChar()
    }
}

fun conversionWord(word: String): String {
    val builder = StringBuilder()
    for (i in word) {
        if (i.isLetter())
            builder.append(conversionChar(i))
        else
            builder.append(i)
    }
    return builder.toString()
}

fun solution4(word: String): String {
    return conversionWord(word)
}
