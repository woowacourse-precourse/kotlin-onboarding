package onboarding

fun solution2(cryptogram: String): String {
    var hasRedundant = true
    var result = cryptogram
    while (hasRedundant) {
        val removeIndexPairList = mutableListOf<Pair<Int, Int>>()
        var lastCharacter = ' '
        var startIndex = -1
        var endIndex = -1
        var flushFlag = false

        result.forEachIndexed { index, c ->
            if (lastCharacter == c) {
                endIndex = index
                flushFlag = true
            } else {
                if (flushFlag) {
                    removeIndexPairList.add(Pair(startIndex, endIndex))
                }
                flushFlag = false
                startIndex = index
                lastCharacter = c
            }
        }
        if (flushFlag) {
            removeIndexPairList.add(Pair(startIndex, endIndex))
        }

        var removedCount = 0
        removeIndexPairList.forEach {
            result = result.replaceRange(it.first - removedCount, it.second - removedCount + 1, "")
            removedCount += it.second - it.first + 1
        }

        hasRedundant = removeIndexPairList.isNotEmpty()
    }
    return result
}
