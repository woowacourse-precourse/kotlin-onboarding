package onboarding

fun solution2(cryptogram: String): String {
    if (isAppropriateCryptogram(cryptogram) != "") {
        return isAppropriateCryptogram(cryptogram)
    }

    return ""
}

fun isAppropriateCryptogram(cryptogram: String): String {
    if (cryptogram.length !in 1..1000) {
        return "cryptogram 길이가 1이상 1000 이하인지 확인해주세요."
    } else if (cryptogram.count { it !in 'a'..'z' } > 0) {
        return "cryptogram에 알파벳 소문자 이외것이 있는지 확인해주세요."
    }
    return ""
}
