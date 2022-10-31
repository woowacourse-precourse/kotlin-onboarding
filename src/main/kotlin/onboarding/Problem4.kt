package onboarding

fun solution4(word: String): String {
    val frogDictionary = mutableMapOf<Char, Char>()
    makeDictionary(frogDictionary)
}

private fun makeDictionary(frogDictionary: MutableMap<Char, Char>) {
    for (i in 0..25) {
        frogDictionary[(65 + i).toChar()] = (90 - i).toChar()
    }
}
