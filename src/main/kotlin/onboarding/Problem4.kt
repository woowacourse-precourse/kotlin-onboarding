package onboarding

fun solution4(word: String): String {
    if (!isAppropriateWord(word)) {
        return "word 길이가 1 이상 1000 이하 문자열인지 확인해주세요."
    }

    var treeFrogWord = ""
    val reverseOrderAlphabet = listOf(
        "Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H",
        "G", "F", "E", "D", "C", "B", "A"
    )

    for (i in word.indices) {
        treeFrogWord += if (word[i] in 'a'..'z') {
            (reverseOrderAlphabet[word[i] - 'a']).lowercase()
        } else if (word[i] in 'A'..'Z') {
            (reverseOrderAlphabet[word[i] - 'A'])
        } else {
        }
    }

    return treeFrogWord
}

fun isAppropriateWord(word: String): Boolean {
    if (word.length !in 1..1000) {
        return false
    }
    return true
}
