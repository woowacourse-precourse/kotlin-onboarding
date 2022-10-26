package onboarding

fun solution4(word: String): String {
    val lower_alphabet = arrayListOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val upper_alphabets  = arrayListOf<Char>() // 초기화
    for (alpha in lower_alphabet) upper_alphabets.add(alpha.uppercaseChar()) // 대문자로 변경뒤 추가
    val re_lower = lower_alphabet.reversed() // 소문자 뒤집기
    val re_upper = upper_alphabets.reversed() // 대문자 뒤집기
    var result : String = ""

    for (char in word) { // result에 변환 된 문자 더하기
        result += if (char == ' ') { // 띄어쓰기인 경우 띄어쓰기 추가
            ' '
        }
        else if (char.isUpperCase()) { // 대문자인 경우 그 대문자의 index를 reverse된 index에 집어넣으면 변환 완료
            re_upper[upper_alphabets.indexOf(char)]
        } else {
            re_lower[lower_alphabet.indexOf(char)]
        }
    }
    return result
}
