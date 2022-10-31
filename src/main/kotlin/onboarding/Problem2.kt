package onboarding

fun solution2(cryptogram: String): String {
    return decoding(cryptogram)
}

fun decoding(cryptogram: String): String {
    var decode = ""
    var encode = cryptogram
    do {
        val alphabet = encode[0]
        if (encode.count { c -> c == alphabet } % 2 == 1) {
            decode = decode.plus(alphabet)
        }
        encode = encode.replace(alphabet.toString(), "")
    } while (encode.isNotEmpty())
    return decode
}