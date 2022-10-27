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