package onboarding

fun solution4(word: String): String {
    val wordToCharList: List<Char> = word.toList()
    var wordReverse = ""

    for ( i in 0..wordToCharList.size - 1){

        wordReverse += frogDictionary(wordToCharList[i])

    }

    return wordReverse
}

fun frogDictionary(letter:Char):Char{

    if(letter.isUpperCase()){

        return (90 - (letter.code - 65)).toChar()

    }else if(letter.isLowerCase()) {

        return (122 - (letter.code - 97)).toChar()

    }else{

        return 32.toChar()
    }

}
