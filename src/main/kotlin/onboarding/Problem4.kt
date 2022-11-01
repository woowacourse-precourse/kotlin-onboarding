package onboarding

/* 소문자, 대문자 구별하는 기능 */
fun divideCase(c: Char): Int {
    if (c.code >= 97 && c.code <= 122) return 1 //소문자
    return if (c.code >= 65 && c.code <= 90) 2 else 0 //대문자
}
