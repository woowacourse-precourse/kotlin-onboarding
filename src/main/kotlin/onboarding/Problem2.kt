package onboarding

/*
기능항목 정리
1. 중복된 문자가 있는지 확인하는 기능
2. 중복된 문자열을 제거하는 기능
 */
fun solution2(cryptogram: String): String {
    var cipherMessage = cryptogram
    var decipheredMessage = decipher(cryptogram)
    while (cipherMessage != decipheredMessage) {
        cipherMessage = decipheredMessage
        decipheredMessage = decipher(cipherMessage)
    }
    return decipheredMessage
}

fun decipher(cipherMessage: String): String {
    return if (cipherMessage.length < 2) cipherMessage
    else cipherMessage.filterIndexed { index, char ->
        when (index) {
            0 -> char != cipherMessage[1]
            cipherMessage.length - 1 -> char != cipherMessage[cipherMessage.length - 2]
            else -> char != cipherMessage[index + 1] && char != cipherMessage[index - 1]
        }
    }
}
