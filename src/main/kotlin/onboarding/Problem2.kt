package onboarding

fun solution2(cryptogram: String): String {
    var processedCryptogram = cryptogram
    var cryptographyState = true

    while (cryptographyState) {
        val stepConclusion = decodeCryptogramStep(processedCryptogram)
        processedCryptogram = stepConclusion.first
        cryptographyState = stepConclusion.second
    }

    return processedCryptogram
}

private fun decodeCryptogramStep(cryptogram: String): Pair<String, Boolean> {
    var cryptographyState = false
    var duplicateRangeSet = mutableSetOf<Int>()
    for (i: Int in cryptogram.indices) {
        var duplicateCount = 0
        if (i in duplicateRangeSet) continue
        for (j: Char in cryptogram.substring(i + 1, cryptogram.length)) {
            if (cryptogram[i] == j) duplicateCount += 1 else break
        }
        if (duplicateCount > 0) {
            duplicateRangeSet.addAll(i..i + duplicateCount)
            cryptographyState = true
        }
    }
    val cryptogramList = cryptogram.toMutableList()
    for (i in duplicateRangeSet.reversed()) cryptogramList.removeAt(i)
    return Pair(cryptogramList.joinToString(""), cryptographyState)
}
