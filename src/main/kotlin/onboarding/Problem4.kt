package onboarding

fun alphaChange(alpha: Char): Char { // 변환된 문자를 return
    val lower_alphabet = arrayListOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val upper_alphabets  = arrayListOf<Char>() // 초기화
    for (alphabet in lower_alphabet) upper_alphabets.add(alphabet.uppercaseChar()) // 대문자로 변경뒤 추가
    val re_lower = lower_alphabet.reversed() // 소문자 뒤집기
    val re_upper = upper_alphabets.reversed() // 대문자 뒤집기

    if (alpha == ' ') return ' '
    if (alpha.isUpperCase()) return re_upper[upper_alphabets.indexOf(alpha)] // alpha에 해당하는 알파벳 위치로 변환한다.
    if (alpha.isLowerCase()) return re_lower[lower_alphabet.indexOf(alpha)]
    return alpha
}
fun solution4(word: String): String {
    var result : String = ""
    for (char in word) result += alphaChange(char)
    return result
}