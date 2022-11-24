package onboarding

fun solution2AnotherCase(cryptogram: String): String {
    return ""
}

private fun isDuplicate(cryptogram: String, index: Int) = cryptogram[index] == cryptogram[index + 1]

private fun hasDuplicate(index: Int, length: Int) = index != length - 1
