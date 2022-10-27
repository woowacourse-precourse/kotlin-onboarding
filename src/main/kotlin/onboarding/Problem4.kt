 package onboarding

fun solution4(word: String): String {
    var changeWord = ""
    for( alphabet in word){
        changeWord = changeWord.plus(change(alphabet))
    }
    return changeWord
}

fun change(alphabet : Char) :Char{
    var ChangeAlphabet = when(alphabet.code){
        in 65..90 -> 155-alphabet.code
        in 97..122 -> 219-alphabet.code
        else -> alphabet.code
    }
    return ChangeAlphabet.toChar()
}
