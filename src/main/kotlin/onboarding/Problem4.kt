package onboarding

fun solution4(word: String): String {
    var answer = ""
    for (char in word) {
        answer += convertChar(char)
    }
    return answer
}

fun convertChar(x: Char): Char {
    val intX = x.code
    if ((intX >= 65) && (intX <= 90)) {
        val gap = intX - 65
        return (90 - gap).toChar()
    }
    if ((intX >= 97) && (intX <= 122)) {
        val gap = intX - 97
        return (122 - gap).toChar()
    }
    return x
}