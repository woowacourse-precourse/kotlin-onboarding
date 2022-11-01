package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
}


fun isAlphabet(char: Char) : Boolean {
    val charCode = char.code
    if ( ('a'.code <= charCode && charCode <= 'z'.code) || (('A'.code <= charCode && charCode <= 'Z'.code)) ) {
        return true
    }

    return false
}