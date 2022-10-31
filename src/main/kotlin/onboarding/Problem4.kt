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
    val conversionTable = mutableMapOf<Char, Char>()

    for (i in upperAlphabetList.indices) conversionTable[upperAlphabetList[i]] = reverseUpperAlphabetList[i]
    for (i in lowerAlphabetList.indices) conversionTable[lowerAlphabetList[i]] = reverseLowerAlphabetList[i]
    conversionTable[' '] = ' '

    return conversionTable
}

private fun getConversionWord(word: String, conversionMap: MutableMap<Char, Char>): String {
    val processedWordList = mutableListOf<Char>()
    for (i: Char in word.toList()) processedWordList.add(conversionMap[i] ?: i)
    return processedWordList.joinToString("")
}
