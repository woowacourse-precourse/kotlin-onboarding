package onboarding

fun solution4(word: String): String {
    val conversionMap = getConversionMap()
    return getConversionWord(word, conversionMap)
}

private fun getConversionMap(): MutableMap<Char, Char> {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val upperAlphabet = alphabet
    val reverseUpperAlphabet = upperAlphabet.reversed()
    val lowerAlphabet = alphabet.lowercase()
    val reverseLowerAlphabet = lowerAlphabet.reversed()
    val conversionMap = mutableMapOf<Char, Char>()

    for (i in upperAlphabet.indices) conversionMap[upperAlphabet[i]] = reverseUpperAlphabet[i]
    for (i in lowerAlphabet.indices) conversionMap[lowerAlphabet[i]] = reverseLowerAlphabet[i]
    conversionMap[' '] = ' '

    return conversionMap
}

private fun getConversionWord(word: String, conversionMap: MutableMap<Char, Char>): String {
    var processedWord = ""
    for (i: Char in word) processedWord += conversionMap[i] ?: i
    return processedWord
}
