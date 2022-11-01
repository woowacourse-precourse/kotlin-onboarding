package onboarding

const val UPPER_CASE_A_NUMBER = 65
const val UPPER_CASE_Z_NUMBER = 90
const val LOWER_CASE_A_NUMBER = 97
const val LOWER_CASE_Z_NUMBER = 122

fun solution4(word: String): String {
    return convertWord(0, word, "")
}

fun convertWord(index : Int, word: String, result : String) : String {
    if (index == word.length) {
        return result
    }
    if (!word[index].isLetter()) {
        return convertWord(index + 1, word, result + word[index])
    }
    return convertWord(index + 1, word, result + getReversedCharacter(word[index]))
}

fun getReversedCharacter(char : Char) : Char{
    if (char.isLowerCase()) {
        return (LOWER_CASE_Z_NUMBER - (char.code - LOWER_CASE_A_NUMBER)).toChar()
    }
    return (UPPER_CASE_Z_NUMBER - (char.code - UPPER_CASE_A_NUMBER)).toChar()
}