package onboarding

fun solution4(word: String): String {
    return convertWord(word)
}

fun convertWord(word: String): String {
    var result = ""

    for(c in word) {
        result += changeCharByFrog(c)
    }

    return result
}

fun changeCharByFrog(c: Char): Char {
    if(c.isUpperCase()) {
        return 'Z' - (c - 'A')
    }
    if(c.isLowerCase()) {
        return 'z' - (c - 'a')
    }

    return c
}