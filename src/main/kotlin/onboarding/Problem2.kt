package onboarding

fun solution2(cryptogram: String): String {
    return checkDuplication(cryptogram)

}

fun checkDuplication(cryptogram: String): String {
    var word = cryptogram
    var resultCrypto = ""
    var checkDuplication = false



    for (j in 0 until cryptogram.length / 2) {
        word += " "
        for (i in 0 until word.length - 1) {

            if (word[i] != word[i + 1]) {
                if (checkDuplication) {

                    checkDuplication = false
                } else {

                    resultCrypto += word[i]
                }
            } else {

                checkDuplication = true
            }
        }

        word = resultCrypto
        checkDuplication = false
        resultCrypto = ""

    }
    return word
}
