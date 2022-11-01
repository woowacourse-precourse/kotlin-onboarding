package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
}


fun isAlphabet(char: Char) : Boolean {
    val charCode = char.code
    if ( ('a'.code <= charCode && charCode <= 'z'.code) || (('A'.code <= charCode && charCode <= 'Z'.code)) ) {
        return true
    }

    return false
}


fun makeDict() : Map<Char, Char> {
    var resultDict = mutableMapOf<Char, Char>()
    for (i in 65..90) {
        resultDict[i.toChar()] = (155-i).toChar()
    }

    for (i in 97..122) {
        resultDict[i.toChar()] = (219-i).toChar()
    }

    return resultDict
}