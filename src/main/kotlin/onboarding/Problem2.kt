package onboarding

fun solution2(cryptogram: String): String {
    var cryptogramWord = cryptogram
    var overlap = true

    while (overlap && cryptogramWord.isNotEmpty()) {
        overlap = false

        for (i in 0 until cryptogramWord.length - 1) {
            if (cryptogramWord[i] == cryptogramWord[i + 1]) {
                cryptogramWord = cryptogramWord.removeRange(i + 1, i + 2)
                cryptogramWord = cryptogramWord.removeRange(i, i + 1)

                overlap = true
                break
            }
            overlap = false
        }
    }
    return cryptogramWord
}