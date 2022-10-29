package onboarding

fun solution2(cryptogram: String): String {
    var decryptedCode = cryptogram

    while (decryptedCode.isNotEmpty()) {
        var changed = false
        var duplicatedTextFlag = false
        var temp = ""
        
        for (i in decryptedCode.indices) {
            if (duplicatedTextFlag) {
                duplicatedTextFlag = false
                continue
            }

            if (i < decryptedCode.length-1
                && decryptedCode[i] == decryptedCode [i+1]) {

                duplicatedTextFlag = true
                changed = true
            } else temp += decryptedCode[i]
        }

        decryptedCode = temp
        
        if (!changed) break
    }

    return decryptedCode
}