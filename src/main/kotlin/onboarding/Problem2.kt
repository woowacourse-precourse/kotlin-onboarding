package onboarding

fun solution2(cryptogram: String): String {
    var text = cryptogram
    while (true) {
        val removedText = removeDuplicate(text)
        if (text == removedText) {
            return text
        }
        text = removedText
    }
}

fun removeDuplicate(text: String): String {
    if (text.length < 2) {
        return text
    }
    var newText = ""
    for (i in text.indices) {
        if ((text[i] != text.getOrNull(i-1)) && (text[i] != text.getOrNull(i + 1))) {
            newText += text[i].toString()
        }
    }

    return newText
}