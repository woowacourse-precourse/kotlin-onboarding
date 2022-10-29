package onboarding

fun main(args: Array<String>) {
    createDictionary()
}

fun solution4(word: String): String {
    TODO("프로그램 구현")
}

//fun changeWord(word: String): String {
//
//}

fun createDictionary(): List<Pair<Char, Char>> {
    val dictionary = mutableListOf<Pair<Char, Char>>()

    repeat(NUMBER_OF_ALPHA) {
        dictionary.add((START_UPPER_ALPHA_CODE + it).toChar() to (END_UPPER_ALPHA_CODE - it).toChar())
        dictionary.add((START_LOWER_ALPHA_CODE + it).toChar() to (END_LOWER_ALPHA_CODE - it).toChar())
    }
    println(dictionary)
    return dictionary
}


fun isAlpha(ch: Char): Boolean {
    if (ch.code in START_UPPER_ALPHA_CODE .. END_LOWER_ALPHA_CODE) return true
    return false
}

const val START_UPPER_ALPHA_CODE = 65
const val END_UPPER_ALPHA_CODE = 90
const val START_LOWER_ALPHA_CODE = 97
const val END_LOWER_ALPHA_CODE = 122
const val NUMBER_OF_ALPHA = 26