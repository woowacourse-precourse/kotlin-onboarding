package onboarding

/*
기능항목 정리
1. 소문자, 대문자, 알파벳이 아닌 문자들을 구분하는 기능
1. 소문자, 대문자, 그리고 공백을 구분하는 기능
2. 알파벳을 규칙대로 치환하는 기능
 */
fun solution4(word: String): String {
    return word.map {
        when (it) {
            in 'a'..'z' -> 'a' + ('z' - it)
            in 'A'..'Z' -> 'A' + ('Z' - it)
            else -> it
        }
    }.joinToString("")
}

