package onboarding

fun solution4(word: String): String {
    val wordToCharList: List<Char> = word.toList()
    var wordReverseResult = ""

    for ( letter in wordToCharList ){
        wordReverseResult += frogDictionary(letter)
    }
    return wordReverseResult
}

fun frogDictionary(letter:Char):Char{

    if(letter.isUpperCase()){
        return (90 - (letter.code - 65)).toChar()

    }
    if(letter.isLowerCase()) {
        return (122 - (letter.code - 97)).toChar()

    }
    return letter

}
