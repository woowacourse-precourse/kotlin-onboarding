package onboarding

fun solution4(word: String): String {
    exception4(word)
    return ""
}

fun exception4(word : String) {
    if(word.length < 1 || word.length > 1000) {
        throw IllegalArgumentException("word의 길이는 1이상 1000이하여야 합니다.")
    }
}
