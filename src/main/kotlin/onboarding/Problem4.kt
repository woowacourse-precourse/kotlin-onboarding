package onboarding

const val LOWER_START_ALPHABET = 'a'
const val LOWER_END_ALPHABET = 'z'
const val UPPER_START_ALPHABET = 'A'
const val UPPER_END_ALPHABET = 'Z'
const val INITIAL_STRING = ""

fun solution4(word: String): String = getReverseWord(word)

private fun alphabetRange(start: Char, end: Char) = (start..end).toList()

private fun getReverseWord(word: String): String {
    var reverseWord = INITIAL_STRING
    word.map { alphabet ->
        reverseWord += if (alphabetRange(LOWER_START_ALPHABET, LOWER_END_ALPHABET).contains(alphabet)) {
            reverseLowerAlphabets()[alphabet]
        } else if (alphabetRange(UPPER_START_ALPHABET, UPPER_END_ALPHABET).contains(alphabet)) {
            reverseUpperAlphabets()[alphabet]
        } else alphabet
    }
    return reverseWord
}

private fun reverseLowerAlphabets(): Map<Char, Char> {
    val lowerAlphabetsMap = mutableMapOf<Char, Char>()
    val lowerAlphabets = alphabetRange(LOWER_START_ALPHABET, LOWER_END_ALPHABET)
    for (i in lowerAlphabets.indices) {
        lowerAlphabetsMap[lowerAlphabets[i]] = lowerAlphabets.reversed()[i]
    }
    return lowerAlphabetsMap
}

private fun reverseUpperAlphabets(): Map<Char, Char> {
    val upperAlphabetsMap = mutableMapOf<Char, Char>()
    val upperAlphabets = alphabetRange(UPPER_START_ALPHABET, UPPER_END_ALPHABET)
    for (upperAlphabet in upperAlphabets.indices) {
        upperAlphabetsMap[upperAlphabets[upperAlphabet]] = upperAlphabets.reversed()[upperAlphabet]
    }
    return upperAlphabetsMap
}
