package onboarding

import kotlin.math.roundToInt

fun solution4(word: String): String {
    return ""
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