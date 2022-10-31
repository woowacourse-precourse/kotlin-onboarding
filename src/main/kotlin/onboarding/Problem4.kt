package onboarding

fun solution4(word: String): String {
    val conversionMap = getConversionMap()
}

private fun getConversionMap(): MutableMap<Char, Char> {
    val alphabet = "ABCDEFGHIJKLMNOPQRXTUVWXYZ"
    val upperAlphabetList = alphabet.toList()
    val reverseUpperAlphabetList = upperAlphabetList.reversed()
    val lowerAlphabetList = alphabet.lowercase().toList()
    val reverseLowerAlphabetList = lowerAlphabetList.reversed()
    val conversionTable = mutableMapOf<Char, Char>()

    for (i in upperAlphabetList.indices) conversionTable[upperAlphabetList[i]] = reverseUpperAlphabetList[i]
    for (i in lowerAlphabetList.indices) conversionTable[lowerAlphabetList[i]] = reverseLowerAlphabetList[i]

    return conversionTable
}
