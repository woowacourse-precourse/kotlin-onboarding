package onboarding

fun solution4(word: String): String {
    var result = ""
    var index =0

    while(index in word.indices)
    {
        result += isChangedChar(word[index])
        index ++
    }
    return result
}

fun isChangedChar(char: Char):Char {

    if (char.isLowerCase()) {
       return (219 - char.code).toChar()
    }
   else if (char.isUpperCase()) {
       return (155 - char.code).toChar()
    }
    return char
}



