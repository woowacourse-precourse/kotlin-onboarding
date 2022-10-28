package onboarding
/*
* 기능 목록
* 각 문자 reverse 구현
* 문자열 전체 reverse 구현
* */

fun Char.reversed(): Char {
    val standardChar = if (this.isUpperCase()) 'A' else 'a'
    return if (this.isLetter()) Char(25 - (this - standardChar) + standardChar.code)
    else this
}

fun solution4(word: String): String {
    TODO("프로그램 구현")
}
