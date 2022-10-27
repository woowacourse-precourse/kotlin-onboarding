package onboarding

fun eraseRepeatedChar(cryptogram: String): String {
    var res = ""
    val len = cryptogram.length
    if (len < 2) return cryptogram
    if (cryptogram[0] != cryptogram[1]) res += cryptogram[0]
    for (i in 1 until len - 1) {
        if (cryptogram[i] == cryptogram[i + 1]) continue
        if (cryptogram[i] == cryptogram[i - 1]) continue
        res += cryptogram[i]
    }
    if (cryptogram[len - 2] != cryptogram[len - 1]) res += cryptogram[len - 1]
    return res
}

fun solution2(cryptogram: String): String {
    TODO("프로그램 구현")
}
