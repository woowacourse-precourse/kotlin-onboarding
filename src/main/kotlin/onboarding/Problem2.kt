package onboarding

fun solution2(cryptogram: String): String {
    return decode(cryptogram)
}

private fun decode(cryptogram: String): String {
    var prev = cryptogram
    var next = removeConsecutiveChars(cryptogram)

    while (prev.length != next.length) {
        prev = next
        next = removeConsecutiveChars(next)
    }

    return next
}

private fun removeConsecutiveChars(text: String): String {
    return buildString {
        for (i in text.indices) {
            if (text.getOrNull(i - 1) == text[i] || text[i] == text.getOrNull(i + 1))
                continue

            append(text[i])
        }
    }
}