package onboarding

fun solution4(word: String): String {
    checkThrowException(word)
    return ""
}

private fun checkThrowException(word: String) {
    throwStringLengthException(word)
}

private fun throwStringLengthException(word: String) {
    if (word.isEmpty() || word.length > 1_000) throw error("word는 길이가 1 이상 1,000 이하인 문자열입니다!")

}
