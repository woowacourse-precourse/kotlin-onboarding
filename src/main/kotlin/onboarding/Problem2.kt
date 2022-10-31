package onboarding

fun solution2(cryptogram: String): String {
    val str = StringBuilder(cryptogram)
    val length = cryptogram.length

    checkCryptogram(cryptogram)

    return decodedCryptogram(str, length)
}

fun decodedCryptogram(str: StringBuilder, length: Int): String {
    var len = length

    for (i in 0 until len) {
        if (i + 1 < str.length) {
            if (str[i] == str[i + 1]) {
                str.delete(i, i + 2)
                len -= 2
                decodedCryptogram(str, len)
            }
        }
    }
    return str.toString()
}

/** 예외 처리 */
private fun checkCryptogram(cryptogram: String) {
    val regex = "^[a-z]*\$".toRegex()

    if (cryptogram.length !in 1..1000) {
        throw IllegalArgumentException(
            "cryptogram은 길이가 1 이상 1000 이하인 문자열이어야 합니다."
        )
    }
    if (!cryptogram.matches(regex)) {
        throw IllegalArgumentException(
            "cryptogram은 알파벳 소문자만 가능합니다."
        )
    }
}
