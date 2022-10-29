package onboarding

fun solution2(cryptogram: String): String {
    var word = cryptogram

    do {
        var loopCheck = false
        for (i in 1 until word.length)
            if (word[i] == word[i-1]) {
                word = word.removeRange(i-1, i+1)
                loopCheck = true
                break
            }
    } while (loopCheck)

    return word
}
