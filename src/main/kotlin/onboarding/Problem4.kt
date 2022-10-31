package onboarding

fun solution4(word: String): String {
    var answer = ""
    for (i in word) {
        answer += translateFroglang(i)
    }
    return answer
}

/**
 *  한 문자를 입력받아 창개구리 문자로 바꿔주는 함f
 */
fun translateFroglang(s: Char): Char {
    if (s == ' ') {
        return ' '
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
    if (s.code > 'a'.code) {
        val answer = frogLang.findOrNull { it.first.toLowerCase() == s }?.second
            ?: throw IllegalArgumentException("$s 가 잘못된 입력값입니다.")
        return answer.toLowerCase()
    }
    return frogLang.findOrNull { it.first == s }?.second ?: throw IllegalArgumentException("$s 가 잘못된 입력값입니다.")
}

/**
 * Char형 문자를 소문자로 바꾸어주는 함수
 */
fun Char.toLowerCase(): Char {
    require(this.code >= 'A'.code && this.code <= 'Z'.code) {
        "$this 대문자 알파벳이 입력되지 않았습니다."
    }
    return (this.code + 32).toChar()
}

/**
 * Pair<Char,Char>형을 지닌 리스트에서 해당 값을 찾는 함수
 */
fun List<Pair<Char, Char>>.findOrNull(predicate: (Pair<Char, Char>) -> Boolean): Pair<Char, Char>? {
    for (element in this) if (predicate(element)) return element
    return null
}