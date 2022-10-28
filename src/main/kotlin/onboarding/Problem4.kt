package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
}

fun change(x: Char): Char {
    val intX = x.code
    return if ((intX >= 65) && (intX <= 90)) {
        val gap = intX - 65
        (90 - gap).toChar()
    } else if ((intX >= 97) && (intX <= 122)) {
        val gap = intX - 97
        (122 - gap).toChar()
    } else {
        x
    }
}