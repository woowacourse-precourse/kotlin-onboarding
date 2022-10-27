package onboarding

fun solution2(cryptogram: String): String {
    exception(cryptogram)
    return ""
}

fun exception(cryptogram: String) {
    if(cryptogram.length < 1 || cryptogram.length > 1000) {
        throw IllegalArgumentException("cryptogram의 길이는 1이상 1000이하여야 합니다.")
    }

    if(!cryptogram.matches("^[a-z]*$".toRegex())) {
        throw IllegalArgumentException("cryptogram은 소문자로 이루어져야 합니다.")
    }
}
