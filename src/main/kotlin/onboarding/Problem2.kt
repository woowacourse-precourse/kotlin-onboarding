package onboarding

fun solution2(cryptogram: String): String {

    var resultCrypto = ""
    var i = 0
    var checkDuplication = false



    while (i < cryptogram.length - 1) {

        if (cryptogram[i] != cryptogram[i + 1]) {
            if (checkDuplication) {
                i++
                checkDuplication = false
            } else {
                resultCrypto += cryptogram[i]
                i++
            }

        } else {
            checkDuplication = true
            i++
        }

    }
    return resultCrypto
    println(resultCrypto)
}
