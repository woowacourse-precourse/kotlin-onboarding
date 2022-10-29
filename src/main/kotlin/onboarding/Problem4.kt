package onboarding

fun solution4(word: String): String {
    var resultString: String = ""
    for (i in word) {
        resultString += changeChar(i)
    }
    return resultString
}

fun changeChar(char: Char): Char {
    if (char == ' ') {
        return ' '
    }
    return notBlank(char)
}

fun notBlank(char: Char): Char {
    if (char >= 'A' && char <= 'Z') {
        return 'Z' - (char - 'A')
    }
    return 'z' - (char - 'a')
}