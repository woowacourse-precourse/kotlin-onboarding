package onboarding

fun solution4(word: String): String {
    val wordToCharList: List<Char> = word.toList()
    var result = ""

    for ( i in 0..wordToCharList.size - 1){
        var frogDictionaryResult: Int

        if(wordToCharList[i].isUpperCase()){

            frogDictionaryResult = 90 - (wordToCharList[i].code - 65)
            result += frogDictionaryResult.toChar()

        }else if(wordToCharList[i].isLowerCase()) {

            frogDictionaryResult = 122 - (wordToCharList[i].code - 97)
            result += frogDictionaryResult.toChar()

        }else{

            result += " "
        }
    }

    return result
}
