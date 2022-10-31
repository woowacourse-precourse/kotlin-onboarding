package onboarding

fun solution4(word: String): String {
    val chars = word.toCharArray()

    chars.forEachIndexed { index, ch ->
        chars[index] = ch.reversedAlpha()
    }
    return String(chars)
}

private fun Char.reversedAlpha(): Char {
    val reversedAlphaMap = createReversedAlphaMap()

    if (this.isAlpha()) {
        return reversedAlphaMap[this] ?: this
    }
    return this
}

private fun Char.isAlpha(): Boolean {
    return this in 'A'..'Z' || this in 'a'..'z'
}

private fun createReversedAlphaMap(): Map<Char, Char> {
    return createReversedLowerAlphaMap() + createReversedUpperAlphaMap()
}

private fun createReversedUpperAlphaMap(): Map<Char, Char> {
    val reversedUpperAlphaMap = mutableMapOf<Char, Char>()
    val upperA = 65
    val upperZ = 90
    val alphaStart = 0
    val alphaEnd = 13

    for (i in alphaStart until alphaEnd) {
        reversedUpperAlphaMap[Char(upperA + i)] = Char(upperZ - i)
        reversedUpperAlphaMap[Char(upperZ - i)] = Char(upperA + i)
    }

    return reversedUpperAlphaMap
}

private fun createReversedLowerAlphaMap(): Map<Char, Char> {
    val reversedLowerAlphaMap = mutableMapOf<Char, Char>()
    val lowerA = 97
    val lowerZ = 122
    val alphaStart = 0
    val alphaEnd = 13

    for (i in alphaStart until alphaEnd) {
        reversedLowerAlphaMap[Char(lowerA + i)] = Char(lowerZ - i)
        reversedLowerAlphaMap[Char(lowerZ - i)] = Char(lowerA + i)
    }

    return reversedLowerAlphaMap
}