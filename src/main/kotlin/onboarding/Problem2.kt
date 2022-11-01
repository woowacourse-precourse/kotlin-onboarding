package onboarding

fun solution2(cryptogram: String): String {
    var isDuplicated = true
    var resultString = cryptogram
    while (isDuplicated) {
        val duplicatedRanges = getDuplicatedRanges(resultString)
        val duplicationsRemovedResult = getDuplicationsRemovedResult(resultString, duplicatedRanges)
        isDuplicated = resultString != duplicationsRemovedResult
        resultString = duplicationsRemovedResult
    }
    return resultString
}

private fun getDuplicatedRanges(string: String): List<List<Int>> {
    val duplicatedRanges = mutableListOf<List<Int>>()
    var lastCharacter = ' '
    var startIndex = -1
    var endIndex = -1
    var isFlushed = true

    string.forEachIndexed { index, c ->
        if (lastCharacter == c) {
            endIndex = index + 1
            isFlushed = false
            return@forEachIndexed
        }
        if (!isFlushed) {
            duplicatedRanges.add(listOf(startIndex, endIndex))
            isFlushed = true
        }
        startIndex = index
        lastCharacter = c
    }
    if (!isFlushed) {
        duplicatedRanges.add(listOf(startIndex, endIndex))
    }

    return duplicatedRanges
}

private fun getDuplicationsRemovedResult(resultString: String, duplicatedRanges: List<List<Int>>): String {
    var duplicationsRemovedResult = resultString
    var removedCount = 0
    duplicatedRanges.forEach { duplicatedRange ->
        val startIndex = duplicatedRange[0] - removedCount
        val endIndex = duplicatedRange[1] - removedCount
        duplicationsRemovedResult = duplicationsRemovedResult.replaceRange(startIndex, endIndex, "")
        removedCount += endIndex - startIndex
    }
    return duplicationsRemovedResult
}
