package onboarding

import kotlin.math.roundToInt

fun solution4(word: String): String {
    val wordBytes = word.toByteArray()
    return getCryptoWord(wordBytes)
}

fun getMiddleLetterAsciiCode(isUpperCase: Boolean): Int {
    return if (isUpperCase)
        (('A'.code.toDouble() + 'Z'.code.toDouble()) / 2).roundToInt()
    else
        (('a'.code.toDouble() + 'z'.code.toDouble()) / 2).roundToInt()
}

fun getCryptoChar(alphabetByte: Byte, isUpperCase: Boolean): Char {
    val middleLetterAsciiCode = getMiddleLetterAsciiCode(isUpperCase)
    return (alphabetByte + (2 * (middleLetterAsciiCode - alphabetByte) - 1)).toChar()
}

fun getCryptoWord(wordBytes: ByteArray): String {
    var editedWord = ""

    for (alphabetByte in wordBytes) {
        editedWord += when (alphabetByte) {
            in 'A'.code..'Z'.code -> {
                getCryptoChar(alphabetByte, true)
            }
            in 'a'.code..'z'.code -> {
                getCryptoChar(alphabetByte, false)
            }
            else -> {
                Char(alphabetByte.toInt())
            }
        }
    }

    return editedWord
}