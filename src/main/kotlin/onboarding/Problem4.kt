package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
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
    val reversedUpperAlphaMap = mutableMapOf<Char, Char>()
    val upperA = 97
    val upperZ = 122
    val alphaStart = 0
    val alphaEnd = 13

    for (i in alphaStart until alphaEnd) {
        reversedUpperAlphaMap[Char(upperA + i)] = Char(upperZ - i)
        reversedUpperAlphaMap[Char(upperZ - i)] = Char(upperA + i)
    }

    return reversedUpperAlphaMap
}