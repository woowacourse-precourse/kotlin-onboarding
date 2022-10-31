package onboarding

fun solution4(word: String): String {
    return changeWord(word = word)
}

fun changeWord(word: String): String {
    val dictionary = createDictionary()
    var newWord = ""

    word.forEach { w ->
        newWord += if (isAlpha(w)) {
            dictionary[w]
        } else w
    }

    return newWord
}

fun createDictionary(): HashMap<Char, Char> {
    val dictionary = hashMapOf<Char, Char>()

    repeat(NUMBER_OF_ALPHA) { order ->
        dictionary[(START_UPPER_ALPHA_CODE + order).toChar()] = (END_UPPER_ALPHA_CODE - order).toChar()
        dictionary[(START_LOWER_ALPHA_CODE + order).toChar()] = (END_LOWER_ALPHA_CODE - order).toChar()
    }

    return dictionary
}

fun isAlpha(ch: Char): Boolean {
    if (ch.code in START_UPPER_ALPHA_CODE..END_LOWER_ALPHA_CODE) return true
    return false
}

const val START_UPPER_ALPHA_CODE = 65
const val END_UPPER_ALPHA_CODE = 90
const val START_LOWER_ALPHA_CODE = 97
const val END_LOWER_ALPHA_CODE = 122
const val NUMBER_OF_ALPHA = 26