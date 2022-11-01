package onboarding

fun solution2(cryptogram: String): String {
    checkThrowException(cryptogram)
    return solveCryptogram(cryptogram)
}

private fun checkThrowException(string: String) {
    throwStringLengthException(string)
    throwLowercaseException(string)
}

private fun throwStringLengthException(string: String) {
    if (string.isEmpty() || string.length > 1_000) throw error("문자열 길이가 1 이상 1000 이하여야 합니다!")
}

private fun throwLowercaseException(string: String) {
    for (i in string.indices) {
        if (!string[i].isLowerCase()) throw error("문자열이 알파벳 소문자로만 이루어져 있어야 합니다!")
    }
}

private fun solveCryptogram(input: String): String {
    val result = input.toMutableList()
    var prevLength = 0

    while (prevLength != result.size) {
        prevLength = result.size
        val deletionList = MutableList(result.size) { false }

        for (i in result.size - 1 downTo 1) {
            if (result[i] == result[i - 1]) {
                deletionList[i] = true
                deletionList[i - 1] = true
            }
        }

        for (j in result.size - 1 downTo 0) {
            if (deletionList[j]) result.removeAt(j)
        }
    }

    return result.joinToString("")
}
