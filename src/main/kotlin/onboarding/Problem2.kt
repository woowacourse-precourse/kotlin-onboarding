package onboarding

fun solution2(cryptogram: String): String {
    var processedCryptogram = cryptogram.toMutableList()
    var cryptographyState = true

    while (cryptographyState) {
        cryptographyState = false
        var duplicateRangeSet = mutableSetOf<Int>()
        for (i: Int in processedCryptogram.indices) {
            var duplicateCount = 0
            for (j: Char in processedCryptogram.subList(i + 1, processedCryptogram.size)) {
                if (processedCryptogram[i] == j) {
                    duplicateCount += 1
                } else break
            }
            if (duplicateCount > 0) {
                duplicateRangeSet.addAll(i..i + duplicateCount)
                cryptographyState = true
            }
        }
        for (i in duplicateRangeSet.reversed()) {
            processedCryptogram.removeAt(i)
        }
    }

    return processedCryptogram.joinToString("")
}
