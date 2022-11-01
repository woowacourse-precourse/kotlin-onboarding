package onboarding

const val UPPERCASE_SUM_CODE = 'A'.code + 'Z'.code
const val LOWERCASE_SUM_CODE = 'a'.code + 'z'.code

fun solution4(word: String): String {
    checkThrowException(word)
    return convertWord(word)
}

private fun checkThrowException(word: String) {
    throwStringLengthException(word)
}

private fun throwStringLengthException(word: String) {
    if (word.isEmpty() || word.length > 1_000) throw error("word는 길이가 1 이상 1,000 이하인 문자열입니다!")

}

private fun convertWord(word: String): String {
    var result = ""

    for (char in word) {
        result += if (char.isUpperCase()) {
            (UPPERCASE_SUM_CODE - char.code).toChar()
        } else if (char.isLowerCase()) {
            (LOWERCASE_SUM_CODE - char.code).toChar()
        } else {
            char
        }
    }

    return result
}
