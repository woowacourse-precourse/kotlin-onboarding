package onboarding

fun solution2(cryptogram: String): String {
    val answer = "answer"
    return answer
}

/* 대,소문자 확인 기능 */
fun smallAlphabetCheck(string: String): Boolean {
    for (i in 0 until string.length) if (Character.isUpperCase(string[i])) return false
    return true
}
