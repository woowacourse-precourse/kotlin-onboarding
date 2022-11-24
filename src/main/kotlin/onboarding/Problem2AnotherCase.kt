package onboarding

fun solution2AnotherCase(cryptogram: String): String  = repeatDecode(cryptogram)


private fun repeatDecode(cryptogram: String): String {
    var loop = true
    var decode = Pair(cryptogram, false)
    while (loop) {
        decode = decode(decode.first)
        loop = decode.second
    }
    return decode.first
}

private fun decode(cryptogram: String): Pair<String, Boolean> {
    var count = 1
    var minusCount = 1
    for (index in cryptogram.indices) {
        if (!hasDuplicate(index,cryptogram.length)) return Pair(cryptogram, false)
        if (isDuplicate(cryptogram, index)) {
            count++
            minusCount--
            if (cryptogram.toList().distinct().size == 1 && cryptogram.length != 1) return Pair("", false)
            if (cryptogram[index +minusCount ] != cryptogram[index + count +minusCount]) {
                return Pair(cryptogram.removeRange(index + minusCount, index + count + minusCount), true)
            }
        }
    }
    return Pair(cryptogram, false)
}
private fun isDuplicate(cryptogram: String, index: Int) = cryptogram[index] == cryptogram[index + 1]

private fun hasDuplicate(index: Int, length: Int) = index != length - 1
