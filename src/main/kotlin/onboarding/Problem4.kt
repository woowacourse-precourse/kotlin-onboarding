package onboarding

/*
    기능 목록
    1. 대문자 알파벳을 주어진 목록에 따라 변환하여 반환하는 함수 reverseUpper
    2. 소문자 알파벳을 주어진 목록에 따라 변환하여 반환하는 함수 reverseLower
 */

fun solution4(word: String): String {
    var result = word
    result = reverseUpper(result)
    result = reverseLower(result)
    return result
}