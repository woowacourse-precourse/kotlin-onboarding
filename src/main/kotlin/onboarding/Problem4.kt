package onboarding

fun solution4(word: String): String {
    var answer = ""
    for (i in word) {
        answer += translateFroglang(i)
    }
    return answer
}

/** 한 문자를 입력받아 창개구리 문자로 바꿔주는 함수 */
fun translateFroglang(s: Char): Char {
    if (s == ' ') {
        return ' '
    }
    if (!isAlphabet(s)) {
        return s
    }
    val frogLang = listOf(
        'A' to 'Z',
        'B' to 'Y',
        'C' to 'X',
        'D' to 'W',
        'E' to 'V',
        'F' to 'U',
        'G' to 'T',
        'H' to 'S',
        'I' to 'R',
        'J' to 'Q',
        'K' to 'P',
        'L' to 'O',
        'M' to 'N',
        'N' to 'M',
        'Z' to 'A',
        'Y' to 'B',
        'X' to 'C',
        'W' to 'D',
        'V' to 'E',
        'U' to 'F',
        'T' to 'G',
        'S' to 'H',
        'R' to 'I',
        'Q' to 'J',
        'P' to 'K',
        'O' to 'L',
    )
    if (s.code >= 'a'.code) {
        val answer = frogLang.find { it.first.toLowerCase() == s }?.second
            ?: throw IllegalArgumentException("$s 가 잘못된 입력값입니다.")
        return answer.toLowerCase()
    }
    return frogLang.find { it.first == s }?.second ?: throw IllegalArgumentException("$s 가 잘못된 입력값입니다.")
}

/** 알파벳인지 판별합니다. */
fun isAlphabet(c: Char): Boolean {
    if (c.code >= 'a'.code && c.code <= 'z'.code) {
        return true
    }
    if (c.code >= 'A'.code && c.code <= 'Z'.code) {
        return true
    }
    return false
}

/** Char형 문자를 소문자로 바꾸어주는 함수 */
fun Char.toLowerCase(): Char {
    require(this.code >= 'A'.code && this.code <= 'Z'.code) {
        "$this 대문자 알파벳이 입력되지 않았습니다."
    }
    return (this.code + 32).toChar()
}