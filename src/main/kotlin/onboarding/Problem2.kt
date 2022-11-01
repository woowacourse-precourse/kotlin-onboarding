package onboarding

fun solution2(cryptogram: String): String {
    return decrypt(cryptogram = cryptogram)
}

fun decrypt(cryptogram: String): String {
    val repetitionReg = Regex(pattern = REPETITION_PATTERN)
    var targetStr = cryptogram

    do {
        targetStr = removeRepetition(cryptogram = targetStr, regex = repetitionReg)
    } while (hasRepetition(cryptogram = targetStr, regex = repetitionReg))

    return targetStr
}

fun hasRepetition(cryptogram: String, regex: Regex): Boolean =
    regex.containsMatchIn(cryptogram)

fun removeRepetition(cryptogram: String, regex: Regex): String =
    cryptogram.replace(regex, "")

const val REPETITION_PATTERN = """(([a-z])\2+)"""

