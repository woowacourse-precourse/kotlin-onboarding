package onboarding

fun solution2(cryptogram: String): String {
    val plainText = StringBuilder("")
    cryptogram.forEach {
        if (plainText.isNotEmpty() && plainText.last() == it) {
            plainText.deleteCharAt(plainText.lastIndex)
        } else {
            plainText.append(it)
        }
    }
    return plainText.toString()
}
