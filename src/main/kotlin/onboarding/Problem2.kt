package onboarding

fun solution2(cryptogram: String): String {

    var newCryptogram = cryptogram
    var isChanged = true

    while (isChanged) {
        isChanged = false
        val newCryptogramCharArray: CharArray = newCryptogram.toCharArray()
        var result = ' '

        for (i in newCryptogramCharArray.indices) {
            val consecutiveDuplicateCharactersExist = newCryptogramCharArray[i] == result

            if (consecutiveDuplicateCharactersExist) {
                newCryptogramCharArray[i] = '-'
                newCryptogramCharArray[i - 1] = '-'
                isChanged = true
            }
            if (!consecutiveDuplicateCharactersExist) result = newCryptogramCharArray[i]
        }

        newCryptogram = String(newCryptogramCharArray)
            .replace("-", "")

    }
    return newCryptogram

}


