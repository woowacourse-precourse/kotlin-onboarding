package onboarding

fun solution4(word: String): String {
    val conversionMap = getConversionMap()
    return getConversionWord(word, conversionMap)
}

private fun getConversionMap(): MutableMap<Char, Char> {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val upperAlphabetList = alphabet.toList()
    val reverseUpperAlphabetList = upperAlphabetList.reversed()
    val lowerAlphabetList = alphabet.lowercase().toList()
    val reverseLowerAlphabetList = lowerAlphabetList.reversed()
    val conversionMap = mutableMapOf<Char, Char>()

    for (i in upperAlphabetList.indices) conversionMap[upperAlphabetList[i]] = reverseUpperAlphabetList[i]
    for (i in lowerAlphabetList.indices) conversionMap[lowerAlphabetList[i]] = reverseLowerAlphabetList[i]
    conversionMap[' '] = ' '

    return conversionMap
}

private fun getConversionWord(word: String, conversionMap: MutableMap<Char, Char>): String {
    val processedWordList = mutableListOf<Char>()
    for (i: Char in word.toList()) processedWordList.add(conversionMap[i] ?: i)
    return processedWordList.joinToString("")
}
