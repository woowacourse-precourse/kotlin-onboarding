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

fun reverseUpper(word: String): String {
    val reverseUpper = word.map { it.code }.toMutableList()
    for (i in word.indices) {
        if (reverseUpper[i].toChar() in 'A'..'Z') {
            reverseUpper[i] = ('A'.code + 'Z'.code) - reverseUpper[i]
        }
    }
    return reverseUpper.map { it.toChar() }.joinToString("")
}

fun reverseLower(word: String): String {
    val reverseLower = word.map { it.code }.toMutableList()
    for (i in word.indices) {
        if (reverseLower[i].toChar() in 'a'..'z') {
            reverseLower[i] = ('a'.code + 'z'.code) - reverseLower[i]
        }
    }
    return reverseLower.map { it.toChar() }.joinToString("")
}
