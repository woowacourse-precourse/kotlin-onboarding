package onboarding

fun solution4(word: String): String {
    var result = ""

    word.forEach {
        if (it.code in 65..90)
            result += (155 - it.code).toChar()

        else if (it.code in 97..122)
            result += (219 - it.code).toChar()

        else
            result += it
    }

    return result
}
