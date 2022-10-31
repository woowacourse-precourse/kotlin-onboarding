package onboarding

fun solution4(word: String): String {
    val frogDictionary = mutableMapOf<Char, Char>()
    makeDictionary(frogDictionary)
    return convertWord(word, frogDictionary)
}

private fun makeDictionary(frogDictionary: MutableMap<Char, Char>) {
    for (i in 0..25) {
        frogDictionary[(65 + i).toChar()] = (90 - i).toChar()
    }
}

private fun convertWord(word: String, frogDictionary: MutableMap<Char, Char>): String {
    var result: String = ""
    for (c in word) {
        result += when (c) {
            in 'A'..'Z' -> frogDictionary[c]
            in 'a'..'z' -> frogDictionary[c.uppercaseChar()]?.lowercaseChar()
            else -> c
        }
    }
    return result
}
