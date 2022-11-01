package onboarding

val regex = Regex(pattern = """([a-z])\1+""");

fun solution2(cryptogram: String): String {
    return removeConsecutiveDuplicates(cryptogram)
}

private fun removeConsecutiveDuplicates(cryptogram: String): String {
    var clearText = cryptogram

    do {
        clearText = clearText.replace(regex, "")
    } while (shouldRepeats(clearText))

    return clearText
}

private fun shouldRepeats(cryptogram: String): Boolean = regex.containsMatchIn(cryptogram)

