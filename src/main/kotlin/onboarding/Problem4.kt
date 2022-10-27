package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
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
        return (122 - (char.toInt()-97)).toChar()
    }
    return (90 - (char.toInt()-65)).toChar()
}