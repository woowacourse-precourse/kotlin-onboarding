package onboarding

fun solution2(cryptogram: String): String {

    var newCryptogram = cryptogram
    var isChanged = true

    while (isChanged) {
        isChanged = false
        val newCryptogramCharArray: CharArray = newCryptogram.toCharArray()
        var result = SPACE_CHARACTER

        for (i in newCryptogramCharArray.indices) {
            val consecutiveDuplicateCharactersExist = newCryptogramCharArray[i] == result

            if (consecutiveDuplicateCharactersExist) {
                newCryptogramCharArray[i] = SIGN_CHARACTER
                newCryptogramCharArray[i - 1] = SIGN_CHARACTER
                isChanged = true
            }
            if (!consecutiveDuplicateCharactersExist) result = newCryptogramCharArray[i]
        }

        newCryptogram = String(newCryptogramCharArray)
            .replace(SIGN_STRING, EMPTY_VALUE)

    }
    return newCryptogram

}

const val SPACE_CHARACTER = ' '
const val EMPTY_VALUE = ""
const val SIGN_CHARACTER = '-'
const val SIGN_STRING = "-"