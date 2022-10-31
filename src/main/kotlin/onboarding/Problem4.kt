package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
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