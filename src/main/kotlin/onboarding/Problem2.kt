package onboarding

const val REMOVE_RANGE_ADD_INDEX = 2
const val COMPARE_NEXT = 1
const val COMPARE_PREVIOUS = -1
fun solution2(cryptogram: String): String {
    return repeatDecode(cryptogram)
}

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
    for (index in cryptogram.indices) {
        if (!hasDuplicate(index, cryptogram.length)) return Pair(cryptogram, false)
        if (isDuplicate(cryptogram, index)) return Pair(
            cryptogram.removeRange(index, index + REMOVE_RANGE_ADD_INDEX),
            true
        )
    }
    return Pair(cryptogram, false)
}

private fun isDuplicate(cryptogram: String, index: Int) = cryptogram[index] == cryptogram[index + COMPARE_NEXT]

private fun hasDuplicate(index: Int, length: Int) = index != length + COMPARE_PREVIOUS