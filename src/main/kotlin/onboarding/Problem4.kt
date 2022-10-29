package onboarding

fun solution4(word: String): String {
    var result = ""

    word.forEach {
        if (it.code in 65..90)
            result += (155 - it.code).toChar()
    }

    return result
}
