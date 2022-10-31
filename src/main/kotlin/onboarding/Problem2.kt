package onboarding

fun solution2(cryptogram: String): String {

    var newCryptogram = cryptogram
    var isChanged = true

    while (isChanged) {
        isChanged = false
        val newCryptogramCharArray: CharArray = newCryptogram.toCharArray()
        var result = ' '

        for (i in newCryptogramCharArray.indices) {

            if (newCryptogramCharArray[i] == result) {
                newCryptogramCharArray[i] = '-'
                newCryptogramCharArray[i - 1] = '-'
                isChanged = true
            }

            if (newCryptogramCharArray[i] != result) result = newCryptogramCharArray[i]
        }

        newCryptogram = String(newCryptogramCharArray)
            .replace("-", "")

    }
    return newCryptogram

}


