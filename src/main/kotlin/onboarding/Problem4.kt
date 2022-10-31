package onboarding

import java.lang.StringBuilder

const val OTHER = 0
const val LOWER = 1
const val UPPER = 2
fun createLowerDictionary(): Map<Char, Char> {
    val lowerDictionary = mutableMapOf<Char, Char>()
    for (i in 0..25) {
        lowerDictionary['a' + i] = ('z' - i)
    }
    return lowerDictionary
}

fun createUpperDictionary(): Map<Char, Char> {
    val upperDictionary = mutableMapOf<Char, Char>()
    for (i in 0..25) {
        upperDictionary['A' + i] = ('Z' - i)
    }
    return upperDictionary
}

fun checkAlphabet(alphabet: Char): Int {
    when {
        alphabet.isLowerCase() -> return LOWER
        alphabet.isUpperCase() -> return UPPER
    }
    return OTHER
}

fun solution4(word: String): String {
    val lowerDictionary = createLowerDictionary()
    val upperDictionary = createUpperDictionary()
    val result = StringBuilder("")

    for (alphabet in word) {
        when (checkAlphabet(alphabet)) {
            LOWER -> result.append(lowerDictionary[alphabet].toString())
            UPPER -> result.append(upperDictionary[alphabet].toString())
            OTHER -> result.append(" ")
        }
    }
    return result.toString()
}