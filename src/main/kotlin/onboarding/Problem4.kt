package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
}

fun changeWord(word: String) {
    val dictionary = listOf('a' to 'z', )
}

fun isAlpha(ch: Char): Boolean {
    if (ch.code in START_ASCII..END_ASCII) return true
    return false
}

const val START_ASCII = 65
const val END_ASCII = 122
const val NUMBER_OF_ALPHA = 26