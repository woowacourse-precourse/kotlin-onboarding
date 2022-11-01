package onboarding

fun isNotDuplicated(cryptogram: String, index: Int): Boolean =
    (cryptogram[index] != cryptogram[index + 1] && index == 0) ||
            (cryptogram[index] != cryptogram[index + 1] && cryptogram[index] != cryptogram[index - 1])

fun getNotDuplicatedChar(cryptogram: String, index: Int): Char? =
    if (isNotDuplicated(cryptogram, index)) cryptogram[index] else null

fun getDeduplicatedString(cryptogram: String, startIndex: Int): Pair<String, Int> {
    var res = cryptogram.slice(0 until startIndex)
    var idx = startIndex
    var isFirst = true

    if (cryptogram.isBlank()) return res to startIndex

    for (i in startIndex until cryptogram.length - 1) {
        val notDuplicatedChar = getNotDuplicatedChar(cryptogram, i)
        res += notDuplicatedChar ?: ""

        if (notDuplicatedChar != null || !isFirst) continue

        idx = if (i == 0) i else i - 1
        isFirst = false
    }

    if (cryptogram[cryptogram.length - 2] != cryptogram.last()) res += cryptogram.last()

    return res to idx
}

fun solution2(cryptogram: String): String {
    var currString = cryptogram
    var currIndex = 0

    while (true) {
        val (newString, nextIndex) = getDeduplicatedString(currString, currIndex)

        if (currString == newString) break

        currString = newString
        currIndex = nextIndex
    }

    return currString
}
