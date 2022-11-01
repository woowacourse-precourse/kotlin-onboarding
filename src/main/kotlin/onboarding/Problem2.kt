package onboarding

fun solution2(cryptogram: String): String {
    validateCryptogram(cryptogram)

    var preCryptogram: String = cryptogram
    var curCryptogram: String = removedConsecutiveDuplicateChar(cryptogram)

    while (preCryptogram != curCryptogram) {
        preCryptogram = curCryptogram
        curCryptogram = removedConsecutiveDuplicateChar(preCryptogram)
    }

    return curCryptogram
}

fun validateCryptogram(cryptogram: String) {
    return when {
        cryptogram.length !in 1..1000 -> throw IllegalArgumentException("cryptogram의 길이는 1 이상 1000 이하인 문자열이어야 합니다.")
        !cryptogram.all { it.isLowerCase() } -> throw IllegalArgumentException("cryptogram은 알파벳 소문자로만 이루어져 있어야 합니다.")
        else -> {}
    }
}

fun removedConsecutiveDuplicateChar(cryptogram: String): String {
    if (cryptogram.isEmpty()) return ""

    var result = StringBuilder()
    var stack = mutableListOf(cryptogram[0])

    for (i in 1 until cryptogram.length) {
        if (stack.last() != cryptogram[i]) {
            if (stack.size == 1) {
                result.append(stack.last())
            }
            stack.clear()
        }
        stack.add(cryptogram[i])
    }
    if (stack.size == 1) {
        result.append(stack.last())
    }
    return result.toString()
}
