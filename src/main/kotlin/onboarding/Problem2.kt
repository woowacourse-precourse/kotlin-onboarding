package onboarding

fun solution2(cryptogram: String): String {
    return decodeCrypto(cryptogram)
}

fun decodeCrypto(cryptogram: String): String { // 문자열 검사, 중복 시 이벤트 처리, 반복
    var resultCrypto = cryptogram
    var cryptoContainer = ""
    var duplicationSwitch = false

    for (i in 0 until cryptogram.length / 2) {
        resultCrypto += " "
        for (j in 0 until resultCrypto.length - 1) {
            if (resultCrypto[j] != resultCrypto[j + 1]) {
                if (duplicationSwitch) {
                    duplicationSwitch = false
                } else {
                    cryptoContainer += resultCrypto[j]
                }
            } else {
                duplicationSwitch = true
            }
        }
        resultCrypto = cryptoContainer
        duplicationSwitch = false
        cryptoContainer = ""
    }
    return resultCrypto
}
